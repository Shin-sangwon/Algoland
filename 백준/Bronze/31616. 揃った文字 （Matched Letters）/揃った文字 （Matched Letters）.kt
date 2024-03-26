import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = readLine().toCharArray().distinct()

    if (arr.size == 1) print("Yes") else print("No")

}