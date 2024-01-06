import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val tc = readLine().toInt()
    val sb = StringBuilder()

    repeat(tc) {
        val n = readLine().toInt()
        var ans = 0
        for(i in 1..n step 2) {
            ans += i
        }

        sb.append("$ans\n")
    }
    print(sb)
}



