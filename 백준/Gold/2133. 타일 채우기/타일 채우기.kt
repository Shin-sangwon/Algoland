import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = IntArray(31)
    arr[0] = 1

    for(i in 2 .. 30 step 2) {
        arr[i] = 3 * arr[i - 2]
        for(j in 4 .. i step 2) {
            arr[i] = arr[i] + 2 * arr[i - j]
        }
    }
    print(arr[n])

}



