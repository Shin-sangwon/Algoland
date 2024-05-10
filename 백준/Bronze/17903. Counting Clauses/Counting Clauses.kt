import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }

    print(if (n >= 8) "satisfactory" else "unsatisfactory")
}