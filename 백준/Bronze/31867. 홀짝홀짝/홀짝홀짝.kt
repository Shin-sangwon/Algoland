import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val str = readLine()

    var odd = 0
    var even = 0

    for(c in str) {
        if(Character.getNumericValue(c) % 2 == 0) even++ else odd++
    }

    when {
        even > odd -> print(0)
        odd > even -> print(1)
        else -> print(-1)
    }
}