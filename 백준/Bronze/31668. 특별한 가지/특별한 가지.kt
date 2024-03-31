import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr = IntArray(3) {readLine().toInt()}
    val idx = arr[1] / arr[0]
    print(idx * arr[2])
}