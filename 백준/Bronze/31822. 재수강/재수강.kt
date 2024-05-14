import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val idx = readLine().substring(0, 5)
    val n = readLine().toInt()
    var ans = 0

    repeat(n) {
        val target = readLine().substring(0, 5)
        if(idx == target) ans++
    }

    print(ans)

}
