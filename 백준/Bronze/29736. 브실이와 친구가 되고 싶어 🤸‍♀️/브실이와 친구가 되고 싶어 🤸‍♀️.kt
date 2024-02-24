import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (a, b) = readLine().split(" ").map { it.toInt() }
    val (x, y) = readLine().split(" ").map { it.toInt() }

    var ans = 0

    for(i in x - y until x + y + 1) {
        if(i in a..b) ans++
    }

    print(if(ans == 0) "IMPOSSIBLE" else ans)

}