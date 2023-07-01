package kotlinPlayground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.min
import java.util.StringTokenizer

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));

    var answer = Integer.MAX_VALUE;

    val st = StringTokenizer(br.readLine());

    val n = st.nextToken().toInt();
    val x = st.nextToken().toInt();

    val price = br.readLine().split(" ").mapNotNull { it.toIntOrNull() }.toMutableList();

    for(i in 0 until n - 1) {

        val tmp = price[i] + price[i + 1];

        val total = tmp * x;

        answer = min(answer, total);
    }

    print(answer);

}



