import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    var answer = 0
    val pq: PriorityQueue<Int> = PriorityQueue()

    repeat(n) {
        pq.add(readLine().toInt())
    }

    while(pq.size != 1) {

        val o1 = pq.poll()
        val o2 = pq.poll()

        answer += o1 + o2
        pq.add(o1 + o2)
    }

    print(answer)
}



