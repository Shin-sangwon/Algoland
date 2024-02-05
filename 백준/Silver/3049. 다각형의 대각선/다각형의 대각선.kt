import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    print(if (n == 3) 0 else (n * (n - 1) * (n - 2) * (n - 3)) / 24)
}