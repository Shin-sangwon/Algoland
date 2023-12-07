import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toLong() }
    val arr = IntArray(n.toInt())
    var max = Int.MIN_VALUE
    for(i in arr.indices) {
        arr[i] = readLine().toInt()
        max = max(max, arr[i])
    }

    var start: Long = 1
    var end: Long = m * max
    var answer: Long = Long.MAX_VALUE
    while(start <= end) {

        val mid: Long = (start + end) / 2
        var numbers: Long = 0
        
        for(i in arr.indices) {
            numbers += mid / arr[i]
            if(numbers >= m) break
        }

        if(numbers >= m) {
            answer = min(mid, answer)
            end = mid - 1
        }else {
            start = mid + 1
        }
    }

    print(answer)
}

