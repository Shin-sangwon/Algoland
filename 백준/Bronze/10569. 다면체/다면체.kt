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

        val v = st.nextToken().toInt();
        val e = st.nextToken().toInt();

        sb.append(calc(v, e)).append("\n");
    }

    print(sb);

}

fun calc(v: Int, e: Int) : Int {

    return 2 - v + e;
}

