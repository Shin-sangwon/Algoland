import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    val ans = arr.sum() - arr.maxOrNull()!!

    print(ans)

}



