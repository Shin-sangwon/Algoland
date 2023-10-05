import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m, k) = br.readLine().split(" ").map{it.toInt()}

    val ans = min(m, k) + min(n - m , n - k)
    
    print(ans)

}