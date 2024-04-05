import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val str = "SciComLove"

    if(n % 2 == 0) print(str) else print(str.reversed())
}