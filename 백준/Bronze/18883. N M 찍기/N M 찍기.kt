import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val target = n * m

    for(i in 1..target) {
        sb.append("$i")
        if(i % m == 0) sb.append("\n")
        else sb.append(" ")
    }

    print(sb)
}


