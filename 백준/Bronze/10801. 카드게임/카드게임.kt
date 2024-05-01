import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val brr = readLine().split(" ").map { it.toInt() }.toIntArray()

    var ac = 0
    var bc = 0

    for(i in arr.indices) {
        val cnt = arr[i] - brr[i]
        when {
            cnt > 0 -> ac++
            cnt < 0 -> bc++
        }
    }

    if(ac == bc) {
        print("D")
    }else {
        if(ac > bc) print("A")
        else print("B")
    }
}