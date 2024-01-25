import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr = LongArray (70)
    arr[0] = 1
    arr[1] = 1
    arr[2] = 2
    arr[3] = 4

    for(i in 4 until arr.size) {
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3] + arr[i - 4]
    }

    val tc = readLine().toInt()
    val sb = StringBuilder()
    repeat(tc) {
        val n = readLine().toInt()
        sb.append("${arr[n]}\n")
    }

    print(sb)
}







