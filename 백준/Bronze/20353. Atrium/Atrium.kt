import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()

    val ans = (4 * sqrt(n.toDouble()))

    print(ans)
}
