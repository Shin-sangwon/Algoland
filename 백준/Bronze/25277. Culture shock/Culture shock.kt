import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())

    var answer = 0

    while(st.hasMoreTokens()) {
        val str = st.nextToken()

        if(calc(str)) {
            answer++
        }
    }

    print(answer)
}

fun calc(str: String): Boolean {

    return when (str) {
        "he" -> true
        "him" -> true
        "she" -> true
        "her" -> true
        else -> false
    }
}