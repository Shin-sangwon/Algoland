import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = intArrayOf(0) + IntArray(n) {readLine().toInt()}
    val count = readLine().toInt()
    var ans = 0

    repeat(count) {
        ans += arr[readLine().toInt()]
    }

    print(ans)
    
}