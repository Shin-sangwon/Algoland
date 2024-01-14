import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr = readLine().split(" ").map { it.toLong() }.toLongArray()
    var ans: Long = 0

    if(arr[0] % 2L != 0L && arr[1] % 2L != 0L) {
        ans = arr.minOf { it }
    }

    print(ans)
}



