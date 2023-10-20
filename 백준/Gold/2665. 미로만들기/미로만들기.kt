import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max


data class Node(val x: Int, val y: Int, val count: Int)
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val map = Array(n) {IntArray(n)}
    val visited = Array(n) {BooleanArray(n)}
    for(i in 0 until n) {
        val str = br.readLine()
        for(j in 0 until n) {
            map[i][j] = str[j].digitToInt()
        }
    }

    visited[0][0] = true
    val start = Node(0, 0, 0)
    val queue:ArrayDeque<Node> = ArrayDeque()
    queue.add(start)
    var answer = 0

    while(queue.isNotEmpty()) {
        val node = queue.poll()

        if(node.x == n-1 && node.y == n-1) {
            answer = node.count
            break
        }
        for(k in 0 until 4) {
            val nx = dx[k] + node.x
            val ny = dy[k] + node.y

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue

            if(visited[nx][ny]) continue

            if(map[nx][ny] == 1) {
                queue.addFirst(Node(nx, ny, node.count))
            }else {
                queue.addLast(Node(nx, ny, node.count + 1))
            }

            visited[nx][ny] = true

        }
    }

    print(answer)
}