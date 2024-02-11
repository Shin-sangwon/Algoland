import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    var max = Int.MAX_VALUE
    var ans = ""

    repeat(n) {
        val (a, b) = readLine().split(" ")
        if(b.toInt() < max) {
            max = b.toInt()
            ans = a
        }
    }

    print(ans)
}