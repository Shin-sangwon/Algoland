import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val n = br.readLine().toLong();

    println(n * (n-1) / 2);
    print(2);
}

