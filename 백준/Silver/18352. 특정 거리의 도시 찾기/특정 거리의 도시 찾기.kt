package kotlinground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer


data class Node(val index: Int, val distance: Int): Comparable<Node> {
    override fun compareTo(other: Node): Int  {
        if(this.distance < other.distance) return -1
        return 1
    }
}

var n: Int = 0
var m: Int = 0
var start: Int = 0
var k: Int = 0
const val MAX_VALUE: Int = 1e9.toInt()
lateinit var short: IntArray
lateinit var graph: MutableList<MutableList<Node>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val sb = StringBuilder()

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    k= st.nextToken().toInt()
    start = st.nextToken().toInt()

    graph = MutableList(n+1) { mutableListOf() }
    short = IntArray(n+1)

    repeat(m) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        graph[start].add(Node(end, 1))
    }

    short.fill(MAX_VALUE)

    dijkstra(start)

    for(i in 1 .. n) {
        if(short[i] == k) {
            sb.append("$i\n")
        }
    }

    if(sb.isEmpty()) print(-1) else print(sb)

}

fun dijkstra(start: Int) {

    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))
    short[start] = 0

    while(pq.isNotEmpty()) {
        val node = pq.poll()
        val dist = node.distance
        val now = node.index

        if(short[now] < dist) continue

        for(i in 0 until graph[now].size) {
            val cost: Int = short[now] + graph[now][i].distance

            if(cost < short[graph[now][i].index]) {
                short[graph[now][i].index] = cost
                pq.add(Node(graph[now][i].index, cost))

            }
        }
    }
}