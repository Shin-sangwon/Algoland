import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, w, h) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    val idx = (w * w) + (h * h)
    repeat(n) {
        val tmp = readLine().toInt()

        if(idx >= tmp * tmp) sb.append("DA\n") else sb.append("NE\n")
    }

    print(sb)
}