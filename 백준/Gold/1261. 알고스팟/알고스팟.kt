import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(val x: Int, val y: Int, val count: Int)

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array (n) {IntArray (m)}
    val visited = Array(n) {BooleanArray(m)}
    var answer = 0
    // 0, 0에서 시작, (N-1, M-1) 도착
    for(i in 0 until n) {
        val str = br.readLine()
        for(j in 0 until m) {
            arr[i][j] = str[j].digitToInt()
        }
    }

    val queue: ArrayDeque<Node> = ArrayDeque()
    queue.add(Node(0, 0, 0))
    visited[0][0] = true

    while(queue.isNotEmpty()) {

        val node = queue.removeFirst()

        if(node.x == n - 1 && node.y == m - 1) {
            answer = node.count
            break
        }

        for(k in 0 until 4) {
            val nx = dx[k] + node.x
            val ny = dy[k] + node.y

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue

            if(visited[nx][ny]) continue

            if(arr[nx][ny] == 0) {
                queue.addFirst(Node(nx, ny, node.count))
            }else {
                queue.addLast(Node(nx, ny, node.count + 1))
            }

            visited[nx][ny] = true

        }
    }

    print(answer)


}