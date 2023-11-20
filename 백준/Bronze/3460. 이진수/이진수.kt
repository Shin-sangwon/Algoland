import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val tc = br.readLine().toInt()

    repeat(tc) {
       var n = br.readLine().toInt()
       var idx = 0
       val location = mutableListOf<Int>()

       while(n != 0) {

           if(n % 2 != 0) location.add(idx)
           idx++
           n /= 2
       }

        sb.append("${location.joinToString(" ")}\n")
    }

    print(sb)
}



