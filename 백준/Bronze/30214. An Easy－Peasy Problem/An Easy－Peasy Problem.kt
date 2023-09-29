
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val(n, m) = br.readLine().split(" ").map { it.toInt() }

    if(n * 2 >= m) {
        print("E")
    }else {
        print("H")
    }
}