import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val idx = n / 2

    if(n % 2 == 0) print((idx + 1).toDouble().pow(2).toInt()) else print((idx + 2) * (idx + 1))
}