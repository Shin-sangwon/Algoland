import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    var answer = 0;
    var str : String?
    while(br.readLine().also { str = it } != null) {
        answer++;
    }

    print(answer);

}

