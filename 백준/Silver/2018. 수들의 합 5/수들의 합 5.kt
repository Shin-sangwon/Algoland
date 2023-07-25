import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    var answer = 0;

    val n = br.readLine().toInt();

    for(i in 1 .. n) {
        for(j in 1 .. n) {
            val sum = (i * j) + (j * (j - 1) / 2);

            if(sum == n) {
                answer++;
                break;
            }

            if(sum > n) {
                break;
            }
        }
    }

    print(answer);
}

