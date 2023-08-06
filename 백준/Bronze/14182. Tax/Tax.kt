import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*
import kotlin.math.ceil


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();

    while(true) {
        var money = br.readLine().toInt();

        if(money == 0) break;

        if(money in 1..999999) {
            sb.append("$money\n");
            continue;
        }

        if(money in 1000000 .. 4999999) {
            money = (money * 0.9).toInt();
            sb.append("$money\n");
            continue;
        }

        money = (money * 0.8).toInt();
        sb.append("$money\n");
    }

    print(sb);
}

