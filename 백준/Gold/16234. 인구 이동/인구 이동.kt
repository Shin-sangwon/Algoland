import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.math.abs

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)
val br = BufferedReader(InputStreamReader(System.`in`))

var n = 0
var MIN = 0
var MAX = 0
var answer = 0

lateinit var map:Array<IntArray>

fun main() {

    init()

    while(bfs()) {
        answer++
    }

    print(answer)

}

fun init() {

    val (nV, minV, maxV) = br.readLine().split(" ").map {it.toInt()}
    n = nV
    MIN = minV
    MAX = maxV

    map = Array(n) { IntArray(n) }

    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for(j in 0 until n) {
            map[i][j] = st.nextToken().toInt()
        }
    }
}

fun bfs() : Boolean {
    // 하나라도 바뀌면 true로 바뀜
    var flag = false
    val visited = Array(n) {BooleanArray(n)}

    for(i in 0 until n) {
        for(j in 0 until n) {

            if(visited[i][j]) continue

            val queue: Queue<Node> = LinkedList()
            val list: MutableList<Node> = ArrayList()
            val now = Node(i, j)

            visited[i][j] = true
            list.add(now)
            queue.add(now)


            while(queue.isNotEmpty()) {

                val node = queue.poll()

                for(k in 0 until 4) {
                    val nx = node.x + dx[k]
                    val ny = node.y + dy[k]

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue

                    if(visited[nx][ny]) continue

                    if(abs(map[nx][ny] - map[node.x][node.y]) in MIN..MAX) {
                        visited[nx][ny] = true
                        queue.add(Node(nx, ny))
                        list.add(Node(nx, ny))
                        flag = true
                    }
                }
            }

            if(list.size != 1) {
                val sum = list.sumOf { node -> map[node.x][node.y] }
                val average = sum / list.size

                list.forEach {map[it.x][it.y] = average}

            }
        }
    }

    return flag
}