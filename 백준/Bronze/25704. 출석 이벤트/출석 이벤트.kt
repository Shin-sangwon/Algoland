import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val price = readLine().toInt()

    val arr = IntArray(4) {price}

    if (n >= 20) arr[3] = (price.toDouble() * 0.75).toInt()
    if (n >= 15) arr[2] = price - 2000
    if (n >= 10) arr[1] = (price.toDouble() * 0.9).toInt()
    if (n >= 5) arr[0] = price - 500
    
    print(arr.minOf { it }.coerceAtLeast(0))
}
