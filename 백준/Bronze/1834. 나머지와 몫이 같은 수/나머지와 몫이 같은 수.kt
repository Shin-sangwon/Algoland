import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toLong()
    val ans = (n - 1) * (n + 1 + (n + 1) * (n - 1)) / 2

    print(ans)
}
