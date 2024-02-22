import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val start = readLine().toInt()
    val end = readLine().toInt()

    print(if(start >= 20) 24 - start + end else end - start)
}