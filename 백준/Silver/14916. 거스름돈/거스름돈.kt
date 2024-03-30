import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    val dp = IntArray(100001)

    dp[1] = -1
    dp[2] = 1
    dp[3] = -1
    dp[4] = 2
    dp[5] = 1

    for(i in 6 until dp.size) {
        when {
            dp[i - 2] == -1 && dp[i - 5] == -1 -> {
                dp[i] = -1
            }
            dp[i - 2] == -1 -> {
                dp[i] = dp[i - 5] + 1
            }
            dp[i - 5] == -1 -> {
                dp[i] = dp[i - 2] + 1
            }
            else -> {
                dp[i] = min(dp[i - 2], dp[i - 5]) + 1
            }
        }
    }

    print(dp[n])
}