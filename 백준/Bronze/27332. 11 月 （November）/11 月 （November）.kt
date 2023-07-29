import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val n: Int = br.readLine().toInt();
    val m: Int = br.readLine().toInt();

    val answer = n + m * 7;

    if(answer > 30) {
        print(0);
    }else {
        print(1);
    }
}

