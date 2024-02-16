import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

var n = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    n = readLine().toInt()
    val arr = intArrayOf(0) + readLine().split(" ").map { it.toInt() }.toIntArray()

    val ans1 = lis(arr)
    val ans2 = reverse(arr)

    var ans = 0
    for(i in ans1.indices) {
        ans = max(ans, ans1[i] + ans2[i] - 1)
    }

    print(ans)

}

fun lis(arr: IntArray) : IntArray {
    val dp = IntArray(n + 1)

    for(i in 1 .. n) {
        dp[i] = 1
        for(j in 1 until i) {
            if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1
            }
        }
    }

    return dp
}

fun reverse(arr: IntArray) : IntArray {
    val dp = IntArray(n + 1)
    for(i in n downTo 1) {
        dp[i] = 1
        for(j in n downTo i) {
            if(arr[i] > arr[j] && dp[j] >= dp[i]) {
                dp[i] = dp[j] + 1
            }
        }
    }
    return dp
}