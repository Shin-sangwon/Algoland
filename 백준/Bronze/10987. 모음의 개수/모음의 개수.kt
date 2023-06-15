import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val input: String = br.readLine();
    var answer: Int = 0;

    for(element in input) {

        val tmp = element;

        if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') {
            answer++;
        }
    }

    print(answer);
}
