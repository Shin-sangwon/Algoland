import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m, z) = br.readLine().split(" ").map {it.toInt()}
    val map = Array (n) { IntArray(m) }

    repeat(z) {
        val (x, y) = br.readLine().split(" ").map {it.toInt()}

        map[x-1][y-1] = 1
    }

    var answer = 0
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val visited = Array (n) {BooleanArray(m)}

    for(i in 0 until n) {
        for(j in 0 until m) {

            if(map[i][j] != 0 && !visited[i][j]) {
                val queue: Queue<Pair<Int, Int>> = LinkedList()
                val now = Pair(i, j)
                visited[i][j] = true
                queue.add(now)
                var tmp = 1
                while(queue.isNotEmpty()) {

                    val node = queue.poll()
                    for(k in 0 until 4) {

                        val nx = dx[k] + node.first
                        val ny = dy[k] + node.second

                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue

                        if(map[nx][ny] != 1) continue

                        if(visited[nx][ny]) continue

                        tmp++
                        visited[nx][ny] = true
                        queue.add(Pair(nx, ny))
                    }
                }

                answer = max(answer, tmp)

            }
        }
    }

    print(answer)
}