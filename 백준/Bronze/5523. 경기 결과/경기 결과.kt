import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    var first = 0
    var second = 0

    repeat(n) {
        val (a, b) = readLine().split(" ").map {it.toInt()}

        if(a > b) first++
        if(a < b) second++
    }

    print("$first $second")
}