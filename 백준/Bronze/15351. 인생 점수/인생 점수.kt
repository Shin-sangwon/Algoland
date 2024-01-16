import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val str = readLine()

        var count = 0

        for(i in str) {
            if(i == ' ') continue
            count += i.code - 64
        }

        if(count == 100) {
            sb.append("PERFECT LIFE\n")
        }else {
            sb.append("$count\n")
        }
    }

    print(sb)

}



