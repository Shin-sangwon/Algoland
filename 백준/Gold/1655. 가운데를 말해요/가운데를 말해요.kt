import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    val sb = StringBuilder()
    val maxHeap = PriorityQueue<Int>(reverseOrder())
    val minHeap = PriorityQueue<Int>()

    repeat(n) {

        val number = readLine().toInt()
        if(maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.add(number)
            sb.append("${maxHeap.peek()}\n")
            return@repeat
        }

        if(number > maxHeap.peek()) {
            minHeap.add(number)
        }else {
            maxHeap.add(number)
        }

        if(minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll())
        }

        if(maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        }

        sb.append("${maxHeap.peek()}\n")
    }

    print(sb)
}