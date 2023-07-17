import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val n = br.readLine().toInt();
    var answer = 0;

    for(i in 0 until n) {

        val input = br.readLine();

        when {
            input.equals("Poblano") -> answer += 1500;
            input.equals("Mirasol") -> answer += 6000;
            input.equals("Serrano") -> answer += 15500;
            input.equals("Cayenne") -> answer += 40000;
            input.equals("Thai") -> answer += 75000;
            else -> answer += 125000;

        }
    }

    print(answer);

}

