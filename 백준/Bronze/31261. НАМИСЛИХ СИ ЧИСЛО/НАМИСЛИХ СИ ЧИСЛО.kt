import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (a, b) = readLine().split(" ").map { it.toInt() }

    print(calc(a, b))
}

fun calc(a: Int, b: Int): Int {

    return (a * a) * (a + b + 1)
}





