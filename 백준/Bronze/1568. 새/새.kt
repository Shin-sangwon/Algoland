import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arr:IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var n = readLine().toInt()
    var bird = 1
    var second = 0

    while(n >= 1) {
        if(n < bird) bird = 1
        else {
            n -= bird++
            second++
        }
    }
    print(second)
}