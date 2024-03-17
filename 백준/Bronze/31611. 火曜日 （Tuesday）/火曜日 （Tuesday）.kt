import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    print(if (readLine().toInt() % 7 == 2) 1 else 0)
}