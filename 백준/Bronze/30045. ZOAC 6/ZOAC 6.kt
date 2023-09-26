import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    var answer = 0

    val idx1 = "01"
    val idx2 = "OI"

    repeat(n) {
        val target = br.readLine()

        for(i in 0 until target.length - 1) {
            val now = target.substring(i, i + 2)
            if(now == idx1 || now == idx2) {
                answer++
                break
            }
        }
    }

    print(answer)
}

