import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    var st = StringTokenizer(br.readLine());

    val n = st.nextToken().toInt();
    val m = st.nextToken().toInt();

    var answer = 0;

    var tmp = Integer.MIN_VALUE;

    st = StringTokenizer(br.readLine());

    for(i in 0 until n) {
        val input = st.nextToken().toInt();

        tmp = max(input, tmp);
    }

    answer += tmp;

    tmp = Integer.MIN_VALUE;
    st = StringTokenizer(br.readLine());

    for(i in 0 until m) {
        val input = st.nextToken().toInt();

        tmp = max(input, tmp);
    }

    print(answer + tmp);

}

