import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()

    for(i in 0 until n) {
        sb.append("*".repeat(i + 1))
        sb.append("\n")
    }

    for(i in n - 1 downTo 1) {
        sb.append("*".repeat(i))
        sb.append("\n")
    }

    print(sb)

}