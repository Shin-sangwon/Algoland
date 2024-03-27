import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }.sorted()
        sb.append("${lcm(a, b)} ${gcd(a, b)}\n")
    }

    print(sb)
}

fun gcd(a: Int, b: Int) : Int {
    if(b == 0) return a
    return gcd(b, a % b)
}

fun lcm(a: Int, b: Int) : Int {
    return (a * b / gcd(a, b));
}