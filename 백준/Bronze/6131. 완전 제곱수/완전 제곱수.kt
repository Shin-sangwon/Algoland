import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    var ans = 0

    for(i in 1..500) {
        val a = i.toDouble().pow(2).toInt()
        for(j in 1..500) {
            val b = j.toDouble().pow(2).toInt()

                if(a == (b + n)) ans++

        }
    }

    print(ans)

}