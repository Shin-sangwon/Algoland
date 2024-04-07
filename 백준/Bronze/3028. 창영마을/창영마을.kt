import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arr:IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val str = readLine()
    arr = IntArray(3)
    arr[0] = 1

    for(c in str) {
        when(c) {
            'A' -> swap(0, 1)
            'B' -> swap(1, 2)
            else -> swap(0, 2)
        }
    }

    for(i in arr.indices) {
        if(arr[i] == 1) {
            print(i + 1)
            return@with
        }
    }
}

fun swap(x: Int, y: Int) {
    val tmp = arr[x]
    arr[x] = arr[y]
    arr[y] = tmp
}