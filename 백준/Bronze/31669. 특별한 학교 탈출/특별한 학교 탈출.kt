import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map {it.toInt()}
    val arr = Array (n) {CharArray(m)}

    for(i in 0 until n) {
        arr[i] = readLine().toCharArray()
    }

    Loop@for(i in 0 until m) {
        for(j in 0 until n) {
            if(arr[j][i] == 'O') continue@Loop
        }

        print("${i + 1}")
        return@with
    }

    print("ESCAPE FAILED")
}