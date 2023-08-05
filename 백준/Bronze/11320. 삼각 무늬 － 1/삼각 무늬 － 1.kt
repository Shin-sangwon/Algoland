import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*
import kotlin.math.ceil


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();
    val tc = br.readLine().toInt();

    for(i in 0 until tc) {

        val st = StringTokenizer(br.readLine());

        val a = st.nextToken().toDouble();
        val b = st.nextToken().toDouble();

        val answer = (ceil((a * a) / (b * b))).toInt();

        sb.append("$answer\n");
    }

    print(sb);

}

