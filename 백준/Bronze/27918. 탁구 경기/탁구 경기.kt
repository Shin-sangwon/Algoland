import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    var d = 0
    var p = 0

    for(i in 0 until n) {
        val str = readLine()

        if(str == "D") d++
        else p++

        if(abs(d - p) > 1) break
    }

    print("$d:$p")

}

