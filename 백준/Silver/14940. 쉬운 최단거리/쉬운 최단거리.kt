import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Node(val x: Int, val y : Int, val value: Int)

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)

val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var map: Array<IntArray>
lateinit var answer: Array<IntArray>
lateinit var start: Node
var n = 0
var m = 0

fun main() {

    init()
    bfs()
    validation()
    
    val sb = StringBuilder()
    for(row in answer) {
        for(element in row) {
            sb.append("$element ")
        }
        sb.append("\n")
    }
    print(sb)
}

fun init() {

    val (nV, mV) = br.readLine().split(" ").map {it.toInt()}
    n = nV;
    m = mV;

    map = Array (n) {IntArray((m))}
    answer = Array (n) {IntArray(m)}

    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for(j in 0 until m) {
            val tmp = st.nextToken().toInt()

            if(tmp == 2) {
                start = Node(i, j, 1)
            }

            map[i][j] = tmp
        }
    }

}

fun bfs() {

    val queue: Queue<Node> = LinkedList()
    queue.add(start)

    while(queue.isNotEmpty()) {

        val node = queue.poll()

        for(k in 0 until 4) {
            val nx = node.x + dx[k]
            val ny = node.y + dy[k]

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue

            if(answer[nx][ny] != 0) continue

            if(map[nx][ny] != 1) continue

            answer[nx][ny] = node.value
            queue.add(Node(nx, ny, node.value + 1))
        }
    }
}

fun validation() {

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(map[i][j] == 1 && answer[i][j] == 0) {
                answer[i][j] = -1
            }
        }
    }
}


