import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var answer: Pair<String, Int> = Pair("name", 500)

    while(true) {
        val st = StringTokenizer(br.readLine())

        val name = st.nextToken()
        val degree = st.nextToken().toInt()

        if(answer.second > degree) {
            answer = Pair(name, degree)
        }

        if(name == "Waterloo") break

    }

    print(answer.first)

}
