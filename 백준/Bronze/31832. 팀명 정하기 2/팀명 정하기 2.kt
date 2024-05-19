import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = Array(n) {readLine()}

    for(i in 0 until n) {
        val str = arr[i]

        if(str.length > 10) continue

        var upper = 0
        var lower = 0
        var digit = 0
        for(c in str) {
            if(c in 'a' .. 'z') lower++
            if (c in 'A' .. 'Z') upper++
            if(c in '0' .. '9') digit++
        }

        if(upper <= lower && digit < str.length) {
            print(str)
            return@with
        }
    }
}