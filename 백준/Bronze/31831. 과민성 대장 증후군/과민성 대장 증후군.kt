import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    var count = 0
    var answer = 0

    for(i in arr.indices) {
        count += arr[i]
        if(count < 0) count = 0
        if(count >= m) answer++
    }

    print(answer)

}