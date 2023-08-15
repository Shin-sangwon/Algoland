import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder();
    val n = br.readLine().toInt();
    val st = StringTokenizer(br.readLine());

    for(i in 0 until n) {
        val tmp = st.nextToken().toInt();

        when {
            tmp == 300 -> sb.append(1).append(" ");
            tmp >= 275 -> sb.append(2).append(" ");
            tmp >= 250 -> sb.append(3).append(" ");
            else -> sb.append(4).append(" ");
        }
    }

    print(sb);
    }


