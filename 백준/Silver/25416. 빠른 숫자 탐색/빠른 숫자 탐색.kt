import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val map = Array(5) { IntArray(5) }
    val visited = Array(5) { BooleanArray(5) }

    for(i in 0 ..< 5) {
        map[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()

    val pair = readLine().split(" ").map { it.toInt() }.let { (a, b) -> Pair(a, b) }
    var answer = -1
    queue.add(Triple(pair.first, pair.second, 0))

    Loop@while(queue.isNotEmpty()) {

        val node = queue.poll()

        for(k in dx.indices) {

            val nx = node.first + dx[k]
            val ny = node.second + dy[k]

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue

            if(visited[nx][ny]) continue

            if(map[nx][ny] == -1) continue

            if(map[nx][ny] == 1) {
                answer = node.third + 1
                break@Loop
            }

            visited[nx][ny] = true
            queue.add(Triple(nx, ny, node.third + 1))
        }

    }


    print(answer)
}
