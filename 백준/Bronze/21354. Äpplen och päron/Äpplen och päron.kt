import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val idx1 = n * 7
    val idx2 = m * 13

    when {
        idx1 > idx2 -> print("Axel")
        idx1 == idx2 -> print("lika")
        else -> print("Petra")
    }


}
