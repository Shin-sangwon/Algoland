import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    var st = StringTokenizer(br.readLine());
    val sb = StringBuilder();

    val n = st.nextToken().toInt();
    val m = st.nextToken().toInt();

    val arr = Array(n) { IntArray(m) };

    for(i in 0 until n) {
        st = StringTokenizer(br.readLine());
        for(j in 0 until m) {
            arr[i][j] = st.nextToken().toInt();
        }
    }

    val queryCnt = br.readLine().toIntOrNull();

    for(k in 0 until queryCnt!!) {
        st = StringTokenizer(br.readLine());
        val n1 = st.nextToken().toInt() - 1;
        val m1 = st.nextToken().toInt() - 1;
        val n2 = st.nextToken().toInt() - 1;
        val m2 = st.nextToken().toInt() - 1;

        var answer = 0;

        for(i in n1..n2) {
            for(j in m1..m2) {
                answer += arr[i][j];
            }
        }

        sb.append("$answer\n");
    }

    print(sb);
}
