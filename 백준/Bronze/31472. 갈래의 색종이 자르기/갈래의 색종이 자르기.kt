import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val ans = sqrt((n * 2).toDouble()).toInt() * 4
    print(ans)
}

