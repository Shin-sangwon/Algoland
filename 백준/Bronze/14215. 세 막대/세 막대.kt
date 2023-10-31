import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray().sorted()

    if(arr[0] + arr[1] > arr[2]) print(arr.sum())
    else print((arr[0] + arr[1]) * 2 - 1)

}


