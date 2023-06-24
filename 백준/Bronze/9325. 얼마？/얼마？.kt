import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();

    val tc = br.readLine().toInt();

    for(i in 0 until tc) {
        var price = br.readLine().toInt();

        val n = br.readLine().toInt();

        for(j in 0 until n) {
            val st = StringTokenizer(br.readLine());

            val num = st.nextToken().toInt();
            val value = st.nextToken().toInt();

            price += num * value;
        }

        sb.append("$price\n");
    }

    print(sb);
}

