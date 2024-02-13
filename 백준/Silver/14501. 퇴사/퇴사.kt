import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr: Array<Pair<Int, Int>> = Array(n ) {Pair(0, 0)}
    val dp = IntArray(n + 1)

    for(i in 0 until n) {
        arr[i] = readLine().split(" ").map { it.toInt() }.let { (a, b) -> Pair(a, b) }
    }

    for(i in n - 1 downTo  0) {
        if(i + arr[i].first <= n) {
            dp[i] = maxOf(dp[i + 1], arr[i].second + dp[i + arr[i].first])
        }else {
            dp[i] = dp[i + 1]
        }
    }

    print(dp[0])
}