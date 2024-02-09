import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val ans = fib(n)
    print("$ans ${n - 2}")


}

fun fib(n: Int) : Int {
    val arr = IntArray(n + 1)
    for(i in 1..2) arr[i] = 1
    for(i in 3 until n + 1) {
        arr[i] = arr[i - 1] + arr[i - 2]
    }

    return arr[n]
}