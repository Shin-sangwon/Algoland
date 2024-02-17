import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val checked = BooleanArray (1000001)
    val ans = IntArray(1000001)

    for(number in arr) {
        checked[number] = true
    }

    for(number in arr) {
        for(start in number * 2 until 1000001 step number) {
            if(checked[start]) {
                ans[number]++
                ans[start]--
            }
        }
    }

    val sb = StringBuilder()
    for(number in arr) {
        sb.append("${ans[number]} ")
    }


    print(sb.trim())
}