import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arr: IntArray
lateinit var dp: Array<BooleanArray>
var n = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    n = readLine().toInt()
    arr = intArrayOf(0) + readLine().split(" ").map { it.toInt() }.toIntArray()
    val sb = StringBuilder()
    val queryCount = readLine().toInt()
    dp = Array (2001) { BooleanArray(2001) }

    for (len in 1..n) {
        for (i in 1..n - len + 1) {
            val j = i + len - 1

            // 길이가 1인 경우 항상 팰린드롬
            if (len == 1) {
                dp[i][j] = true
                continue
            }

            // 길이가 2인 경우 두 문자가 같으면 팰린드롬
            if (len == 2) {
                dp[i][j] = arr[i] == arr[j]
                continue
            }

            // 3 이상은 이전 길이가 팰린드롬이고 양 끝 문자가 같으면 팰린드롬
            dp[i][j] = dp[i + 1][j - 1] && arr[i] == arr[j]
        }
    }
    repeat(queryCount) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        val ans = if (dp[a][b]) 1 else 0
        sb.append("$ans\n")
    }

    print(sb)
}