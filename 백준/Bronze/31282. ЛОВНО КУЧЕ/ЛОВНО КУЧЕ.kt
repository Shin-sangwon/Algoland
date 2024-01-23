import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val idx = k - m

    val ans = if (n % idx == 0) n / idx else n / idx + 1
    print(ans)

}



