import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.pow


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();

    val n: Int = br.readLine().toInt();

    for(i in 0 until n) {
        val tmp: Int = br.readLine().toInt();
        var ans: Int = 0;

        for(j in 1..tmp) {
           ans += j * (j + 1) * (j + 2) / 2;
        }

        sb.append("$ans\n");
    }

    print(sb);
}

