import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().substring(0, 3)
    if(str == "555") print("YES") else print("NO")
}