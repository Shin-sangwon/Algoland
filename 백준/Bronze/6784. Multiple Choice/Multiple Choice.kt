import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    val test = Array<String>(n) {"it = $it"}
    val ans = Array<String>(n) {"it = $it"}

    for(i in 0 until n) {
        test[i] = readLine()
    }

    for(i in 0 until n) {
        ans[i] = readLine()
    }

    var answer = 0
    for(i in 0 until n) {
        if(test[i] == ans[i]) answer++
    }

    print(answer)
}



