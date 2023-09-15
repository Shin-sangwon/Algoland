import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

val br = BufferedReader(InputStreamReader(System.`in`))
var n = 0
var m = 0
var target = 0
lateinit var cost: IntArray
lateinit var arr: IntArray
lateinit var dp: IntArray
lateinit var graph: Array<LinkedList<Int>>

fun main() {

    val tc = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(tc) {
        init()
        val ans = topologicalSort()
        sb.append("$ans\n")
    }
    print(sb)
}

fun init() {

    val (nV, mV) = br.readLine().split(" ").map { it.toInt() }
    n = nV
    m = mV
    cost = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    arr = IntArray(n + 1)
    dp = IntArray(n + 1) { 0 }
    graph = Array(n + 1) { LinkedList() }

    repeat(m) {
        val (first, second) = br.readLine().split(" ").map { it.toInt() }
        graph[first].add(second)
        arr[second]++
    }

    target = br.readLine().toInt()
}

fun topologicalSort(): Int {
    val queue: Queue<Int> = LinkedList()

    for (i in 1..n) {
        dp[i] = cost[i - 1]
        if (arr[i] == 0) queue.add(i)
    }

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        for (n in graph[now]) {
            dp[n] = max(dp[n], dp[now] + cost[n - 1])
            arr[n]--

            if (arr[n] == 0) queue.add(n)
        }
    }

    return dp[target]
}
