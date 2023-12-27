import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, x, k) = readLine().split(" ").map { it.toInt() }
    var ans = x

    repeat(k) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        if(a == ans) {
            ans = b
        }else if(b == ans) {
            ans = a
        }
    }

    print(ans)

}