import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();

    val n = br.readLine().toInt();

    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine());

        val a = st.nextToken().toInt();
        val b = st.nextToken().toInt();

        val idx = i + 1;
        val ans = a + b;
        sb.append("Case $idx: $ans\n");
    }

    print(sb);

}

