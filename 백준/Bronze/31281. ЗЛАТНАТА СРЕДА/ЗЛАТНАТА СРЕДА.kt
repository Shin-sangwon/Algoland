import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr = readLine().split(" ").map { it.toLong() }.toLongArray().sorted()
    print(arr[1])
}



