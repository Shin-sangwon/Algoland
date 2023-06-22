package kotlinPlayground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();
    val n = br.readLine().toInt();

    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine());

        val legs = st.nextToken().toInt();
        val chicken = st.nextToken().toInt();

        val abnormal = chicken * 2 - legs;
        val normal = chicken - abnormal;


        sb.append("$abnormal $normal\n");
    }

    print(sb);
}

