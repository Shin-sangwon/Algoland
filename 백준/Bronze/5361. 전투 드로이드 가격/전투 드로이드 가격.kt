import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val arr = doubleArrayOf(350.34, 230.90, 190.55, 125.30, 180.90)
    val sb = StringBuilder()
    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }.toIntArray()
        var ans = 0.0
        for(i in arr.indices) {
            ans += arr[i] * input[i]
        }
        sb.append(String.format("$%.2f\n", ans))
    }

    print(sb)
}