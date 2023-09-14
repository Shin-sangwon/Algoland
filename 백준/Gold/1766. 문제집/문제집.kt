import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))

var n = 0
var m = 0
lateinit var arr:IntArray
lateinit var graph: Array<LinkedList<Int>>

fun main() {

    init()
    val ans = topologicalSort()

    print(ans.joinToString(" "))
}

fun init() {
    val (nV, mV) = br.readLine().split(" ").map { it.toInt() }
    n = nV
    m = mV

    arr = IntArray(n+1)
    graph = Array(n+1) {LinkedList()}

    repeat(m) {
        val (f, s) = br.readLine().split(" ").map { it.toInt() }
        graph[f].add(s)
        arr[s]++
    }
}

fun topologicalSort(): List<Int> {

    val ans = mutableListOf<Int>()
    val queue: Queue<Int> = PriorityQueue()

    for (i in 1..n) {
        if (arr[i] == 0) queue.add(i)
    }

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        ans.add(now)

        for (n in graph[now]) {
            arr[n]--
            if (arr[n] == 0) queue.add(n)
        }
    }

    return ans
}