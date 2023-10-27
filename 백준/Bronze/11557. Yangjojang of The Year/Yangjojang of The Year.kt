import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val tc = br.readLine().toInt()

    repeat(tc) {
        val n = br.readLine().toInt()
        var idx = -1
        var answer = ""
        for(i in 0 until n) {
            val(str, tmp) = br.readLine().split(" ")
            val count = tmp.toInt()

            if(count > idx) {
                idx = count
                answer = str
            }
        }

        sb.append("$answer\n")
    }

    print(sb)

}


