import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, k) = readLine().split(" ").map { it.toInt() }
    val idx = 2.0.pow(n - 1).toInt()

    print(k / idx)

}