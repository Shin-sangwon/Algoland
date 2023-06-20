package kotlinPlayground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    var num = 0;
    var score = 0;

    for(i in 1..5) {
        val st = StringTokenizer(br.readLine());
        var tmp = 0;
        while(st.hasMoreTokens()) {
            tmp += st.nextToken().toInt();
        }

        if(tmp > score) {
            score = tmp;
            num = i;
        }
    }

    print("$num $score");
}

