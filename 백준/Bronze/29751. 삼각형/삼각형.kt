import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toFloat() }

    print("%.1f".format(n * m / 2))
}