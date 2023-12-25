import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    var ans = 0
    val idx = (m / 2) + 1

    repeat(n) {
        val str = readLine()
        var count = 0
        for(i in str) {
            if(i == 'O') count++
        }

        if(count >= idx) ans++
    }

    print(ans)

}