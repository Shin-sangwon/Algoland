import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()

    for(i in 1..n) {

        when (br.readLine().toInt()) {
            in 1.. 25 -> sb.append("Case #${i}: World Finals\n")
            in 26..1000 -> sb.append("Case #${i}: Round 3\n")
            in 1001 .. 4500 -> sb.append("Case #${i}: Round 2\n")
            else -> sb.append("Case #${i}: Round 1\n")
        }
    }

    print(sb)
}




