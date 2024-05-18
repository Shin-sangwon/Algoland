import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val sb = StringBuilder()

    while(!find(arr)) {
        for(i in 0 until arr.size - 1) {
            if(arr[i] > arr[i + 1]) {
                val tmp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = tmp
                sb.append("${arr.joinToString(" ")}\n")
            }
        }
    }

    print(sb)
}

fun find(arr: IntArray): Boolean {
    return arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 4 && arr[4] == 5
}