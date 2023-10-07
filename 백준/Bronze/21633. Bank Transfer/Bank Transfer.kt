import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val count = 25 + n * 0.01

    when {
        count < 100 -> print(100)
        count > 2000 -> print(2000)
        else -> print(count)
    }

}