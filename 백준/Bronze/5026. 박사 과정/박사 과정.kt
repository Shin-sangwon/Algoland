import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.ceil


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();
    val n = br.readLine().toInt();

    for(i in 0 until n) {
        val tmp = br.readLine();

        if(tmp.contains("+")) {
            val st = StringTokenizer(tmp, "+");

            val a = st.nextToken().toInt();
            val b = st.nextToken().toInt();

            val answer = a + b;
            sb.append("$answer\n");
            continue;
        }

        sb.append("skipped\n");
    }

    print(sb);
}

