import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    val sb = StringBuilder()
    var j = 1
    for (i in 0 until 2 * n) {
        for (k in 0 until 2 * n) {
            print(if (k >= j && k < 2 * n - j) " " else "*")
        }

        if (i < n - 1)
            j++
        else
            j--

        println()
    }
}



