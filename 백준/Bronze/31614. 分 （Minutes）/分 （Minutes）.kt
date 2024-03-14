import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val h = readLine().toInt()
    val m = readLine().toInt()
    print("${h * 60 + m}")
}

