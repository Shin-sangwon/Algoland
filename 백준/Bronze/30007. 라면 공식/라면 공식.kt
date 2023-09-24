package kotlinground

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()


    repeat(n) {
        val (a, b, x) = br.readLine().split(" ").map { it.toInt() }
        val answer = (a * (x - 1)) + b
        sb.append("$answer\n")
    }

    print(sb)
}