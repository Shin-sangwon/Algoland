import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val(n, m) = br.readLine().split(" ").map { it.toInt() }

    var a = 0
    var b = 0

    for(i in 0 until n) {
        br.readLine().forEach { char ->
                when(char) {
                    '0' -> a++
                    '1' -> b++
                }
        }
    }

    print(min(a, b))

}


