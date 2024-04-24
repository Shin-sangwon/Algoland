
import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    sb.append(n.toString().repeat(n))

    if(sb.length < m) print(sb) else print(sb.substring(0, m))

}