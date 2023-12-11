import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val idx = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    var answer = 1

    for(i in arr.indices) {
        if(arr[i] > idx) answer++
    }

    print(answer)
}

