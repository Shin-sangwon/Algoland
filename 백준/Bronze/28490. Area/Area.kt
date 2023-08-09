import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.pow


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val n: Int = br.readLine().toInt();
    var answer = 0;
    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine());

        val a = st.nextToken().toInt();
        val b = st.nextToken().toInt();
        val ans = a * b;

        answer = max(answer, ans);
    }

    print(answer);
}

