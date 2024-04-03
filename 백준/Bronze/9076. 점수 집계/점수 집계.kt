import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val arr = readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
        if(arr[3] - arr[1] >= 4) {
            sb.append("KIN\n")
        }else {
            sb.append("${arr[1] + arr[2] + arr[3]}\n")
        }
    }

    print(sb)
}