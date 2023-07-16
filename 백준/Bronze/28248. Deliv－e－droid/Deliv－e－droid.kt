import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val n = br.readLine().toInt();
    val m = br.readLine().toInt();

    var answer = n * 50 - m * 10;

    if(n > m) {
        answer += 500;
    }

    print(answer);

}

