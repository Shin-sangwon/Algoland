import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val tc = readLine().toInt()
    val sb = StringBuilder()

    repeat(tc) {
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

        val min = arr.minOf { it }
        val max = arr.maxOf { it }
        val ans = (max - min) * 2
        sb.append("$ans\n")
    }

    print(sb)
}



