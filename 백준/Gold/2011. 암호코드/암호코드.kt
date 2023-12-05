import java.io.BufferedReader
import java.io.InputStreamReader

const val MOD = 1000000

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val numbers = readLine().split("").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()

    print(calc(numbers))
}

fun calc(numbers: IntArray): Int{

    if(numbers[0] == 0) return 0

    val dp = IntArray(numbers.size + 1) { 0 }
    dp[0] = 1
    dp[1] = 1

    for(i in 2..numbers.size) {

        val first = numbers[i - 1]
        val second = (numbers[i - 2] * 10) + first

        if(first > 0) dp[i] = (dp[i] + dp[i - 1]) % MOD

        if(second in 10..26) dp[i] = (dp[i] + dp[i - 2]) % MOD
    }

    return dp[numbers.size]

}