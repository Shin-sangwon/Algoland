import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()


    repeat(n) {
        val st = StringTokenizer(readLine())
        val sb = StringBuilder()
        val idx = st.nextToken().toInt()
        val str = st.nextToken()

        sb.append("$str\n").deleteCharAt(idx - 1)
        print(sb)
    }

}