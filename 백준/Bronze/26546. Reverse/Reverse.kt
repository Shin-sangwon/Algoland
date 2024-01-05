import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val st = StringTokenizer(readLine())
        val str = st.nextToken()
        val startIdx = st.nextToken().toInt()
        val endIdx = st.nextToken().toInt() - 1

        for(i in str.indices) {
            if(i in startIdx..endIdx) continue
            sb.append(str[i])
        }

        sb.append("\n")
    }

    print(sb)
}



