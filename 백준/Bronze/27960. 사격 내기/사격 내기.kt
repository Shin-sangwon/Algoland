import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        val a = n or m
        val b = n and m

        print(a - b)
    }


