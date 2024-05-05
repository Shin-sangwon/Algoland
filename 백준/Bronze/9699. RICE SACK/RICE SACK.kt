import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()
    val str = "Case #%d: %d\n"

    for(i in 1..n) {
        val ans = readLine().split(" ").map { it.toInt() }.maxOf { it }
        sb.append(str.format(i, ans))
    }

    print(sb)

}