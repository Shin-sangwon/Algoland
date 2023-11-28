import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.sorted()
    var currentMax = 0

    for (weight in arr) {
        if (weight > currentMax + 1) {
            break
        }
        currentMax += weight
    }

    print(currentMax + 1)
}
