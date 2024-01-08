import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val sb = StringBuilder()
    val ans = "Mary won %d times and John won %d times\n"

    while(true) {
        val n = readLine().toInt()
        if(n == 0) break

        val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

        var mary = 0
        var john = 0

        for(i in arr.indices) {
            if(arr[i] == 0) mary++
            else john++
        }

        sb.append(ans.format(mary, john))
    }

    print(sb)
}



