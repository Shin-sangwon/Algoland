import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

lateinit var stack: Stack<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val a = readLine()
    val b = readLine()
    val c = readLine()
    println(a.toInt() + b.toInt() - c.toInt())
    print((a + b).toInt() - c.toInt())
}