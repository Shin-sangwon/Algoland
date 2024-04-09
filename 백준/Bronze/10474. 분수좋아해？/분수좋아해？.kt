import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val sb = StringBuilder()
    while(true) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        if(n == 0 && m == 0) break

        val num = n / m
        val numerator = n - (num * m)
        sb.append("$num $numerator / $m\n")
    }

    print(sb)
}