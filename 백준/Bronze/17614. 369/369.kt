import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    var ans = 0

    for(i in 1..n) {
        val str = i.toString()
        for(c in str) {
            val idx = Character.getNumericValue(c)
            if(idx % 3 == 0 && idx != 0) ans++
        }
    }

    print(ans)
}