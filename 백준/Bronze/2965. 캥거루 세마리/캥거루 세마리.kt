import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

    val answer = max(b - a, c - b)

    print(answer - 1)

}