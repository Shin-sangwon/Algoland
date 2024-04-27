import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val str = readLine()
    print(abs(str[0].code - 'I'.code) + 84)
}