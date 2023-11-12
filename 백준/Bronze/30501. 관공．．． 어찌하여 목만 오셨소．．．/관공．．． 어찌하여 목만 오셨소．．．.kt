import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    for(i in 0 until n) {

        val str = readLine()
        if(str.contains('S')) {
            print(str)
            break
        }
    }
}
