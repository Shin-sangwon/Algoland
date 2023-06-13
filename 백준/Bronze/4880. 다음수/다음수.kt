import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();

    val ap = "AP";
    val gp = "GP";

    while (true) {
        val st = StringTokenizer(br.readLine());

        val a1 = st.nextToken().toInt();
        val a2 = st.nextToken().toInt();
        val a3 = st.nextToken().toInt();

        if(a1 == 0 && a2 == 0 && a3 == 0) break;

        val idx1 = a2 - a1;
        val idx2 = a3 - a2;

        if(idx1 == idx2) {
            val tmp = a3 + idx1;
            sb.append("$ap $tmp\n");
            continue;
        }

        val tmp = a3 * (a2 / a1);
        sb.append("$gp $tmp\n");
    }

    print(sb);
}
