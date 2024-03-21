import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    print(if(arr[0] + arr[1] == arr[2]) "correct!" else "wrong!")
}

