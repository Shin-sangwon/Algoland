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

        var a = st.nextToken().toInt();
        val b = st.nextToken().toInt();

        var answer = 0;

        answer += a / b;

        val tmp = a % b;

        if(tmp != 0) {
            answer += 1;
        }

        sb.append("$answer\n");
    }

    print(sb);

}



