package kotlinPlayground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();

    val n = br.readLine().toInt();

    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine());

        val r = st.nextToken().toInt();
        var e = st.nextToken().toInt();
        val c = st.nextToken().toInt();

        e -= c;

        val idx = r - e;

        when {
            idx < 0 -> sb.append("advertise\n");
            idx > 0 -> sb.append("do not advertise\n");
            else -> sb.append("does not matter\n");
        }
    }

    print(sb);

}

