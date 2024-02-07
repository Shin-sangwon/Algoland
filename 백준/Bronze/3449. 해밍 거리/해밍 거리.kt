import java.io.BufferedReader
import java.io.InputStreamReader

private const val str = "Hamming distance is %d.\n"

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val tc = readLine().toInt()
    val sb = StringBuilder()

    repeat(tc) {
        val n = readLine()
        val m = readLine()

        var answer = 0

        for(i in n.indices) {
            if(n[i] != m[i]) answer++
        }

        sb.append(String.format(str, answer))
    }

    print(sb)
}