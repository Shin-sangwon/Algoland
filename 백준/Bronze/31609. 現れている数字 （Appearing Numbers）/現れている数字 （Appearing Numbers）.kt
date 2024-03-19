import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val ans = readLine().split(" ").map { it.toInt() }.distinct().sorted().joinToString("\n")
    print(ans)
}