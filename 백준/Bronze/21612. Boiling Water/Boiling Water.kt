import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val n = br.readLine().toInt();

    val p = 5 * n - 400;

    var ans = 0;

    when {
        p < 100 -> ans = 1;
        p > 100 -> ans = -1;
        else -> 0;
    }

    println(p);
    println(ans);

}

