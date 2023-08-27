import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()

    repeat(n) {
        val arr: List<Long> = br.readLine().split(" ").map { it.toLong() }
        arr.sorted()
        val ans = arr[0] * arr[1] / gcd(arr[1], arr[0])
        sb.append("$ans\n")
    }

    print(sb)

}

fun gcd(a: Long, b: Long): Long {

    return if(b == 0L) a
    else gcd(b, a % b)
}
