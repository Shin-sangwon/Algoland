import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();

    val n = br.readLine().toInt();

    val a = 5;
    val b = 3;

    for(i in 0 until n) {
        for(j in 0 until n * a) {
            sb.append("@");
        }
        sb.append("\n");
    }

    for(i in 0 until n * b) {
        for(j in 0 until n) {
            sb.append("@");
        }
        sb.append("\n");
    }

    for(i in 0 until n) {
        for(j in 0 until n * a) {
            sb.append("@");
        }
        sb.append("\n");
    }

    print(sb);

}

