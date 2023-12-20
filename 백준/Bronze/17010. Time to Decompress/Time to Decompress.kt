import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));
    val n = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val character = st.nextToken().repeat(num)

        sb.append("$character\n")

    }

    print(sb)
}



