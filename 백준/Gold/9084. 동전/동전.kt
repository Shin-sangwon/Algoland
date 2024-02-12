import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val tc = readLine().toInt()
    val sb = StringBuilder()
    repeat(tc) {
        val n = readLine().toInt()
        val coins = readLine().split(" ").map { it.toInt() }.toIntArray()
        val target = readLine().toInt()

        val arr = IntArray(target + 1)
        arr[0] = 1

        coins.forEach { x ->
            for(i in x .. target) {
                arr[i] += arr[i - x]
            }
        }
        sb.append("${arr[target]}\n")
    }
    print(sb)
}