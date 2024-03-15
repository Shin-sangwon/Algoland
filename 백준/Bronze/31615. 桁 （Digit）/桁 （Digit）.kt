import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val a = readLine().toInt()
    val b = readLine().toInt()
    print((a+b).toString().length)
}

