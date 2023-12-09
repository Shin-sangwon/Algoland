import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val sb = StringBuilder()

    val idx = "++++"
    val idx2 = "|"

    val n = readLine().toInt()
    repeat(n) {

        val now = readLine().toInt()

        val idxCount = now / 5
        for(i in 0 until idxCount) {
            sb.append("$idx ")
        }

        val idx2Count = now % 5
        for(i in 0 until idx2Count) {
            sb.append(idx2)
        }

        sb.append("\n")
    }

    print(sb)
}

