import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var (n, m) = readLine().split(" ").map { it.toInt() }

    var ans = n

    while(n >= m) {
        n /= m
        ans += n
    }

    print(ans)
}



