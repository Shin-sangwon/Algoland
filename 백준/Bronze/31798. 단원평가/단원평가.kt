import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (a, b, c) = readLine().split(" ").map { it.toInt() }

    if(c == 0) {
        val ans = sqrt((a + b).toDouble()).toInt()
        print(ans)
    }else {
        val target = c * c
        val idx = if(a == 0) b else a
        val ans = target - idx
        print(ans)
    }

}
