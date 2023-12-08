import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arr: List<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m, l) = readLine().split(" ").map { it.toInt() }

    arr = if(n != 0) {
        (listOf(0) + readLine().split(" ").map { it.toInt() } + listOf(l)).sorted()
    }else {
        mutableListOf(0, l)
    }

    var start = 1
    var end = l
    var answer = l
    while(start <= end) {

        val mid = (start + end) / 2
        var count = 0

        for(i in 0 until arr.size - 1) {
            count += (arr[i + 1] - arr[i] - 1) / mid
        }

        if(count > m) {
            start = mid + 1
        } else {
            answer = mid
            end = mid - 1
        }
    }

    print(answer)

}

