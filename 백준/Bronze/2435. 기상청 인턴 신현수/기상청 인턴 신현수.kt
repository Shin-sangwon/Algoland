import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val st = StringTokenizer(br.readLine());

    val n = st.nextToken().toInt();
    val k = st.nextToken().toInt();

    val arr = br.readLine()?.split(" ")?.map { it.toInt() }?.toIntArray();

    var init = 0;
    var answer = 0;

    for(i in 0 until k) {
        init += arr!![i];
        answer += arr[i];
    }

    for(i in 0 until n - k) {
        init -= arr!![i];
        init += arr[i + k];
        answer = max(answer, init);
    }

    print(answer);

}
