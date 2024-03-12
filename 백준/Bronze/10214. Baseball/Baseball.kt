import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    val sb = StringBuilder()
    val y = "Yonsei"
    val k = "Korea"
    val d = "Draw"
    repeat(n) {
        var yonsei = 0
        var korea = 0

        repeat(9) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            yonsei += x
            korea += y
        }

        when {
            yonsei > korea -> sb.append("$y\n")
            yonsei < korea -> sb.append("$k\n")
            else -> sb.append("$d\n")
        }
    }

    print(sb)
}