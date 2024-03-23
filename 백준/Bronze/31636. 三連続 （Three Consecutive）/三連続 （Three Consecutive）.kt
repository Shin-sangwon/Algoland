import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val str= readLine()

    val contains = str.windowed(3, 1).any { it == "ooo" }
    println(if (contains) "Yes" else "No")

}

