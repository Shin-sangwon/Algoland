import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val pq: PriorityQueue<String> = PriorityQueue()
    repeat(n) {
        val str = readLine()
        if(str.length == 3) pq.add(str)
    }

    print(pq.poll())
}

