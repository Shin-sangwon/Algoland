package kotlinPlayground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();
    val tc = br.readLine().toInt();

    for(i in 1..tc) {
        val n = br.readLine().toInt();
        var tmp = 0;
        val st = StringTokenizer(br.readLine());

        for(j in 0 until n) {
            tmp += st.nextToken().toInt();
        }

        sb.append("$tmp\n");
    }

    print(sb);
}

