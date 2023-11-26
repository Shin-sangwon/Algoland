import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr: Array<Pair<Int, Int>> = Array(n) {Pair(0, 0)}
    val pq = PriorityQueue<Pair<Int, Int>>() {o1, o2 -> o1.second - o2.second}

    for(i in 0 until n) {
        val pair = readLine().split(" ").let { (a, b) -> Pair(a.toInt(), b.toInt()) }
        arr[i] = pair
    }

    arr.apply { sortBy { it.first }}.forEach { lecture ->
        if(pq.isNotEmpty() && lecture.first >= pq.peek().second) {
            pq.poll()
        }

        pq.add(lecture)
    }

    print(pq.size)

}
