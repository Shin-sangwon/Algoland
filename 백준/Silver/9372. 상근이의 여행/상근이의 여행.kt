import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val tc = readLine().toInt()
    val sb = StringBuilder()

    repeat(tc) {
        val(n, m) = readLine().split(" ").map { it.toInt() }
        for(i in 0 until m) {
            readLine()
        }

        sb.append("${n-1}\n")
    }

    print(sb)

}