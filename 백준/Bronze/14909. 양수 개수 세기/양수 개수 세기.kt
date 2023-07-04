import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val answer = br.readLine().split(" ").map { x -> x.toInt() }.count { y -> y > 0 };

    print(answer);
}

