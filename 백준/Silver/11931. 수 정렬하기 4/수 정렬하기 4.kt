import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val pq: PriorityQueue<Int> = PriorityQueue(reverseOrder())

    repeat(n) {
        val tmp = readLine().toInt()
        pq.add(tmp)
    }

    val sb = StringBuilder()

    while(pq.isNotEmpty()) {
        sb.append("${pq.poll()}\n")
    }

    print(sb)

}







