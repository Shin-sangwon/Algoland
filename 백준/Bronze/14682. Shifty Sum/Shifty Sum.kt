import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var n = readLine().toInt()
    val times = readLine().toInt()

    var ans = 0

    repeat(times + 1) {
        ans += n
        n *= 10
    }

    print(ans)


}