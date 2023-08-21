import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Node(val x: Int, val y: Int, val length: Int)

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tc = br.readLine().toInt()
    val sb = StringBuilder()
    var st: StringTokenizer

    loop@ while (tc-- > 0) {
        st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val map = Array(n) { CharArray(m) }
        val visited = Array(n) { BooleanArray(m) }
        val queue: Queue<Node> = LinkedList()

        for (i in 0 until n) {
            val line = br.readLine()
            for (j in 0 until m) {
                map[i][j] = line[j]
                if (map[i][j] == 'S') {
                    queue.add(Node(i, j, 0))
                    visited[i][j] = true
                }
            }
        }

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (map[node.x][node.y] == 'G') {
                sb.append("Shortest Path: ").append(node.length).append("\n")
                continue@loop
            }

            for (k in 0..3) {
                val nx = node.x + dx[k]
                val ny = node.y + dy[k]
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
                if (visited[nx][ny]) continue
                if (map[nx][ny] == 'X') continue

                queue.add(Node(nx, ny, node.length + 1))
                visited[nx][ny] = true
            }
        }
            sb.append("No Exit\n")

    }

    println(sb)
}


