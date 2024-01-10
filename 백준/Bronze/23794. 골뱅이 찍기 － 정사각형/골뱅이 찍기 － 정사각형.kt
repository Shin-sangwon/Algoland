import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()

    for(i in 0 until n + 2) {
        sb.append("@")
    }

    sb.append("\n")

    for(i in 0 until n) {
        sb.append("@")
        for(j in 0 until n) {
            sb.append(" ")
        }
        sb.append("@\n")
    }

    for(i in 0 until n + 2) {
        sb.append("@")
    }

    print(sb)
}



