import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val sb = StringBuilder()

    for(i in 1..100000) {
        sb.append(i)
    }

    val n = readLine()
    val ans = sb.toString().indexOf(n)
    print(ans + 1)
}







