import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val str = readLine()

    for(i in 0 until str.length / 2) {
        if(str[i] != str[str.length - i - 1]) {
            print("false")
            return@with
        }
    }

    print("true")
}