import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    var count = 0
    repeat(3) {
        if(readLine().split(" ").map { it.toInt() }.toIntArray().any { it == 7 }) count++
    }

    print(if (count == 3) "777" else "0")
}

