import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    var answer = br.readLine().toInt();
    var idx = "";

    while(true) {

        var tmp = br.readLine();

        if(tmp.equals("=")) {
            break;
        }

        if(tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/")) {
            idx = tmp;
            continue;
        }

        when {
            idx.equals("+") -> answer += tmp.toInt();
            idx.equals("-") -> answer -= tmp.toInt();
            idx.equals("*") -> answer *= tmp.toInt();
            else -> answer /= tmp.toInt();
        }

    }

    print(answer);
}

