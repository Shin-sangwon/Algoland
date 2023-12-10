import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    val idx = arr[0]
    var ans = 0
    for(i in 1 until arr.size) {
        if(idx - arr[i] <= 1000) ans++
    }

    print(ans)
}

