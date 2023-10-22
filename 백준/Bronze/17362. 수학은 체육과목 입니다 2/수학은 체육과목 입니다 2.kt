import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong() % 8
    var answer = 0
    answer = when (n) {
        0L -> 2
        6L -> 4
        7L -> 3
        else -> n.toInt()
    }

    print(answer)

}
