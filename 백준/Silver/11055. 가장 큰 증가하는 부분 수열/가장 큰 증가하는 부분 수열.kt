import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    val dp = IntArray(n) {arr[it]}

    for(i in 1 until n) {
        for(j in 0 until i) {
            if(arr[j] < arr[i]) dp[i] = max(dp[i], dp[j] + arr[i])
        }
    }

    val ans = dp.maxOrNull() ?: 0

    print(ans)

}