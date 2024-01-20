import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue { o1, o2 -> o1.second - o2.second}
    val arr = Array (n) {Pair(0, 0)}

    for(i in 0 until n) {
        val pair:Pair<Int, Int> = readLine().split(" ").let { (a, b, c) -> Pair(b.toInt(), c.toInt()) }
        arr[i] = pair
    }

    arr.apply { sortBy { it.first } }.forEach { lecture ->
        if(pq.isNotEmpty() && lecture.first >= pq.peek().second) {
            pq.poll()
        }
        pq.add(lecture)
    }

    print(pq.size)

}



