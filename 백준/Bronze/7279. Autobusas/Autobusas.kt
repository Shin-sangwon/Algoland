import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val(n, m) = br.readLine().split(" ").map { it.toInt() }

    var answer = 0
    var now = 0
    repeat(n) {
        val(i, o) = br.readLine().split(" ").map { it.toInt() }

        now += i
        now -= o

        if(now > m) {
            answer = maxOf(answer, now - m)
        }
    }

    print(answer)
}