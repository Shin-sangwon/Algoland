import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var(n, m, k) = br.readLine().split(" ").map { it.toInt() }

    val answer = generateSequence {
        if (n >= 2 && m >= 1 && n + m >= 3 + k) {
            n -= 2
            m -= 1
            1
        } else null
    }.sum()

    print(answer)

}


