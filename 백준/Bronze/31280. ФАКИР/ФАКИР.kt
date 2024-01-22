import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr = readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
    val ans = arr[1] + arr[2] + arr[3] + 1

    print(ans)

}



