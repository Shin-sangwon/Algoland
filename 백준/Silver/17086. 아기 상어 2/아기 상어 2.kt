import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

data class Node(val x: Int, val y: Int, val count: Int)

val dx = intArrayOf(1, 1, 1, 0, 0, -1, -1, -1)
val dy = intArrayOf(1, 0, -1, 1, -1, 1, 0, -1)


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    var ans = 0

    for(i in 0 until n) {
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for(i in 0 until n) {
        Loop@for(j in 0 until m) {
            if(arr[i][j] == 1) {
                continue
            }

            val start = Node(i, j, 0)
            val visited = Array (n) {BooleanArray (m)}
            visited[i][j] = true

            val queue: Queue<Node> = LinkedList()
            queue.add(start)

            while(queue.isNotEmpty()) {
                val node = queue.poll()

                for(k in dx.indices) {
                    val nx = node.x + dx[k]
                    val ny = node.y + dy[k]

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue

                    if(visited[nx][ny]) continue

                    visited[nx][ny] = true
                    if(arr[nx][ny] == 1) {
                        ans = max(ans, node.count + 1)
                        continue@Loop
                    }

                    queue.add(Node(nx, ny, node.count + 1))
                }
            }
        }
    }

    print(ans)

}



