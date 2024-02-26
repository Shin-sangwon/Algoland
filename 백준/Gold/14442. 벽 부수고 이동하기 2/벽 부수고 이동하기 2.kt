import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

data class Node(val x: Int, val y: Int, val cnt: Int, val wallCount: Int)

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)
lateinit var map: Array<IntArray>
lateinit var visited: Array<Array<BooleanArray>>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    map = Array (n) {IntArray(m)}
    for(i in 0 until n) {
        map[i] = readLine().toCharArray().map { Character.getNumericValue(it) }.toIntArray()
    }

    visited = Array(n) { Array(m) {BooleanArray(k + 1)} }
    val start = Node(0, 0, 1, k)
    val queue: Queue<Node> = LinkedList()
    queue.add(start)
    var answer = -1

    for(i in 0 until k) {
        visited[0][0][i] = true
    }

    while(queue.isNotEmpty()) {
        val node = queue.poll()

        if(node.x == n - 1 && node.y == m - 1) {
            answer = node.cnt
            break
        }

        for(i in 0 until 4) {
            val nx = node.x + dx[i]
            val ny = node.y + dy[i]

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue

            if(map[nx][ny] == 1 && node.wallCount > 0 && !visited[nx][ny][node.wallCount]) {
                visited[nx][ny][node.wallCount] = true
                queue.add(Node(nx, ny, node.cnt + 1, node.wallCount - 1))
                continue
            }

            if(map[nx][ny] == 0 && !visited[nx][ny][node.wallCount]) {
                visited[nx][ny][node.wallCount] = true
                queue.add(Node(nx, ny, node.cnt + 1, node.wallCount))
            }
        }
    }

    print(answer)
}