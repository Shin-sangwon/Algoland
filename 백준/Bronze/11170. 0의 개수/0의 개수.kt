import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    
    val sb = StringBuilder()
    val tc = readLine().toInt()

    repeat(tc) {
        val(n, m) = readLine().split(" ").map { it.toInt() }
        var ans = if(n == 0) 1 else 0
        for (i in n .. m) {
            var now = i
            while(now != 0) {
                if(now % 10 == 0) ans++
                now /= 10
            }
        }
        sb.append("$ans\n")
    }

    print(sb)
}
