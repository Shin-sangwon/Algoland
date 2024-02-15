import java.io.BufferedReader
import java.io.InputStreamReader

const val MOD: Long = 1000000000

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = Array (n + 1) { LongArray (10) }

    for(i in 1..9) {
        arr[1][i] = 1
    }

    for(i in 2 .. n) {
        for(j in 0 until 10) {
            if(j == 0) {
                arr[i][j] = arr[i - 1][1] % MOD
                continue
            }

            if(j == 9) {
                arr[i][j] = arr[i - 1][8] % MOD
                continue
            }

            arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % MOD
        }
    }

    var ans = 0L
    for(i in 0 until 10) {
        ans += arr[n][i]
    }

    print(ans % MOD)
}