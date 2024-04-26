import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val str = readLine()

    print(if(str.contains("d2") || str.contains("D2")) "D2" else "unrated")

}