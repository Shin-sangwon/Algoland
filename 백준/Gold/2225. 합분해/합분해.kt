package kotlinground

import java.io.BufferedReader
import java.io.InputStreamReader

const val MOD = 1_000_000_000

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val(n, k) = br.readLine().split(" ").map {it.toInt()}
    val dp = Array(k+1) {IntArray(n+1)}

    // dp[i][j]가 i개의 수를 더해서 j를 만드는 경우의 수라면
    for(i in 0 .. n) {
        dp[1][i] = 1 // 1개의 수를 더해 j를 만드는 방법은 1개
    }

    for(i in 2 .. k) {
        for(j in 0 .. n) {
            for( l in 0..j) {
                dp[i][j] += dp[i-1][j-l]
                dp[i][j] %= MOD
            }
        }
    }

    print(dp[k][n])


}



