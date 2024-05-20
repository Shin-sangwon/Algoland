import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val price = readLine().toDouble() * 0.8
        sb.append("$${String.format("%.2f", price)}\n")
    }

    print(sb)
}
