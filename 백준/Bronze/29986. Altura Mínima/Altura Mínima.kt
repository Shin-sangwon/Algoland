import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val(n, height) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    print(arr.count { x -> x <= height })
}

