import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val a = readLine().toBigInteger()
    val b = readLine().toBigInteger()
    val c = readLine().toBigInteger()

    val res = a.multiply(b).multiply(c).toString()
    val arr = IntArray(10)

    for(c in res) {
        arr[c.code - 48]++
    }

    arr.forEach { println(it) }
}



