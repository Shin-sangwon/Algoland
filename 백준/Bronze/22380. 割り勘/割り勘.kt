import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val sb = StringBuilder();

    while(true) {
        var st = StringTokenizer(br.readLine());

        val n = st.nextToken().toInt();
        val m = st.nextToken().toInt();

        if(n == 0 && m == 0) {
            break;
        }

        st = StringTokenizer(br.readLine());

        val idx = m / n;
        var ans = 0;

        for(i in 0 until n) {
            val tmp = st.nextToken().toInt();

            ans += if(tmp >= idx) {
                idx;
            }else {
                tmp;
            }

        }

        sb.append("$ans\n");
    }

    print(sb);
}

