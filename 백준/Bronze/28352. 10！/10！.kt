import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val n = br.readLine().toInt();

    var answer = 1L;

    val idx = 3628800L / 6;

    for(i in 2..n) {
        answer *= i;
    }

    print(answer / idx);
}

