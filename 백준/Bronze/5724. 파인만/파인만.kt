import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    while(true) {
        val n = readLine().toInt()

        if(n == 0) break

        var answer = 0

        for(i in 1 .. n) {
            answer += i * i
        }

        sb.append("$answer\n")
    }

    print(sb)
}
