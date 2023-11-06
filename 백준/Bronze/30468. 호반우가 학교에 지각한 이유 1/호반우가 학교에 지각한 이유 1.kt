import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (a, b, c, d, n) = br.readLine().split(" ").map {it.toInt()}

    val sum = a + b + c + d
    val targetSum = 4 * n
    val answer = if (targetSum > sum) targetSum - sum else 0

    print(answer)

}
