import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = Array (10) { BooleanArray(20) }
    val n = readLine().toInt()

    repeat(n) {
        val str = readLine()
        val alpha = str[0] - 'A'
        val number = str.substring(1, str.length).toInt()
        arr[alpha][number - 1] = true

    }

    for(i in arr.indices) {
        for(j in arr[i].indices) {
            if(arr[i][j]) print("o") else print(".")
        }
        println()
    }
}