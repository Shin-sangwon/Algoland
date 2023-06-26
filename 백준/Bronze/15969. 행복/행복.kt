package kotlinPlayground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.lang.Math.min
import java.util.StringTokenizer

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));

    var max = Integer.MIN_VALUE;
    var min = Integer.MAX_VALUE;

    val n = br.readLine().toInt();
    val st = StringTokenizer(br.readLine());

    while(st.hasMoreTokens()) {
        val nextInt = st.nextToken().toInt();

        max = max(max, nextInt);
        min = min(min, nextInt);
    }

    print(max - min);

}

