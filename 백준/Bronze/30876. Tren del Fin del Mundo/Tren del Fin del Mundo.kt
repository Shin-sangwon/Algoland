import java.io.BufferedReader
import java.io.InputStreamReader


lateinit var pair: Pair<Int, Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    var idx = Int.MAX_VALUE
    repeat(n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        if(b < idx) {
            idx = b
            pair = Pair(a, b)
        }
    }

    print("${pair.first} ${pair.second}")
}

