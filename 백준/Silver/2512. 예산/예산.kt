import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val limit = readLine().toInt()

    var answer = 0

    if(arr.sum() <= limit) {
        answer = arr.maxOf { it }
    }else {
        var start = 0
        var end = limit
        while(start <= end) {
            val mid = (start + end) / 2
            var count = 0

            for(i in arr.indices) {
                count += if(arr[i] <= mid) {
                    arr[i]
                }else {
                    mid
                }
            }

            if(count <= limit) {
                answer = max(answer, mid)
                start = mid + 1
            }else {
                end = mid - 1
            }
        }
    }

    print(answer)

}