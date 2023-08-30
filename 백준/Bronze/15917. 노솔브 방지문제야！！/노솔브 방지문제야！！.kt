import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()

    repeat(n) {
        val tmp = br.readLine().toInt()

        if( (tmp and -tmp) == tmp) sb.append("1\n")
        else sb.append("0\n")
    }

    print(sb)
}


