package kotlinPlayground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();

    val honest = "Stan may be honest\n";
    val disHonest = "Stan is dishonest\n";

    val tooHigh = "too high";
    val tooLow = "too low";
    val rightOn = "right on";

    var visited = BooleanArray(11) { false };

    while (true) {
        val number = br.readLine().toInt();

        if (number == 0) break;

        val answer = br.readLine();

        if(answer.equals(tooHigh)) {

            for (i in number..10) {
                visited[i] = true;
            }

            continue;
        }

        if(answer.equals(tooLow)) {

            for(i in number downTo 1) {
                visited[i] = true;
            }

            continue;
        }

        if(answer.equals(rightOn)) {

            if(visited[number]) {
                sb.append(disHonest);
            }else {
                sb.append(honest);
            }

            visited = BooleanArray(11) { false };
        }


    }

    print(sb);
}

