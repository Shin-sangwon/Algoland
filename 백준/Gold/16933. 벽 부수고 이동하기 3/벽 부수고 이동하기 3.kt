import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.Queue

data class Node(val x: Int, val y: Int, val cnt: Int, val wallCount: Int, val day: Int)

val dx = intArrayOf(1, 0, -1, 0, 0)
val dy = intArrayOf(0, 1, 0, -1, 0)
lateinit var map: Array<IntArray>
lateinit var visited: Array<Array<Array<BooleanArray>>>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    map = Array (n) {IntArray(m)}
    for(i in 0 until n) {
        map[i] = readLine().toCharArray().map { Character.getNumericValue(it) }.toIntArray()
    }

    visited = Array(n) { Array(m) { Array(k + 1) {BooleanArray (2)} }}
    val start = Node(0, 0, 1, k, 0)
    val queue: Queue<Node> = ArrayDeque()
    queue.add(start)
    var answer = -1


    while(queue.isNotEmpty()) {
        val node = queue.poll()

        if(node.x == n - 1 && node.y == m - 1) {
            answer = node.cnt
            break
        }

        for(i in 0 until 5) {
            val nx = node.x + dx[i]
            val ny = node.y + dy[i]

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue
            // 낮, 밤, 제자리
            if(map[nx][ny] == 1 && node.wallCount > 0 && !visited[nx][ny][node.wallCount][node.day]) {

                if(node.day == 0) {
                    if(i == 4) {
                        visited[nx][ny][node.wallCount][0] = true
                        queue.add(Node(nx, ny, node.cnt + 1, node.wallCount, 1))
                        continue
                    }

                    visited[nx][ny][node.wallCount][0] = true
                    queue.add(Node(nx, ny, node.cnt + 1, node.wallCount - 1, 1))
                    continue
                }else {
                    if(i == 4) {
                        visited[nx][ny][node.wallCount][1] = true
                        queue.add(Node(nx, ny, node.cnt + 1, node.wallCount, 0))
                    }
                }

            }

            if(map[nx][ny] == 0 && !visited[nx][ny][node.wallCount][node.day]) {
                if(i == 4) {
                    visited[nx][ny][node.wallCount][node.day] = true
                    queue.add(Node(nx, ny, node.cnt + 1, node.wallCount, if(node.day == 0) 1 else 0))
                    continue
                }
                visited[nx][ny][node.wallCount][node.day] = true
                queue.add(Node(nx, ny, node.cnt + 1, node.wallCount, if(node.day == 0) 1 else 0))
            }
        }
    }

    print(answer)
}