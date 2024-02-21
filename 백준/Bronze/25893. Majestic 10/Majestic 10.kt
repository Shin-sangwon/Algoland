import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

        val ans = when (arr.count { x -> x >= 10 }) {
            0 -> "zilch"
            1 -> "double"
            2 -> "double-double"
            else -> "triple-double"
        }

        sb.append(arr.joinToString(separator = " ") { "$it" })
        sb.append("\n$ans\n\n")
    }

    print(sb.trim())

}