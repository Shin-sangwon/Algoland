import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val str = readLine()
    var left = 0
    var right = 0

    for(i in str.indices) {
        val value = Character.getNumericValue(str[i])
        if(i < str.length / 2) left += value
        else right += value
    }

    print(if(left == right) "LUCKY" else "READY")

}