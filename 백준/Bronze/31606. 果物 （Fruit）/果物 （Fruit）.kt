import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val arr = IntArray(2) {readLine().toInt()}
    print(arr.sum() + 3)
}