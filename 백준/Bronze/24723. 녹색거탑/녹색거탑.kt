import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val n: Double = br.readLine().toDouble();

    print(2.0.pow(n).toInt());
}

