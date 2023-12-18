import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val str = readLine()
    val arr = IntArray(26)

    for(i in str) {
        if(i.code in 97..122) {
            arr[i.code - 97]++
        }
    }

    var ans = -1

    for(i in arr.indices) {
        if(arr[i] > ans) ans = arr[i]
    }

    print(ans)



}

