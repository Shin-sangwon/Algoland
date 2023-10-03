
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toDouble()

    val answer = 4 * sqrt(n)

    print(String.format("%.8f", answer))
}
