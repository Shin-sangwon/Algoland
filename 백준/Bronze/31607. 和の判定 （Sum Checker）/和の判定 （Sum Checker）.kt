import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val arr = IntArray(3) {readLine().toInt()}.sorted()
    print(if(arr[0] + arr[1] == arr[2]) 1 else 0)
}

