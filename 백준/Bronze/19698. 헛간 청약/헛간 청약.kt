import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, w, h, l) = br.readLine().split(" ").map { it.toInt() }

    val count = (w / l) * (h / l)

    if(count >= n) print(n) else print(count)
}



