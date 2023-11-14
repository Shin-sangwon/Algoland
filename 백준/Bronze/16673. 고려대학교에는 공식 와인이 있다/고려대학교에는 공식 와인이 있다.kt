import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

    var start = 1
    var answer = 0
    while(start <= a) {

        answer += (start * b) + (c * start * start)

        start++
    }

    print(answer)
}



