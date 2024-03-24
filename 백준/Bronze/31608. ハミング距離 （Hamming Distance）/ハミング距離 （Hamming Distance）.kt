import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val a = readLine()
    val b = readLine()

    var ans = 0

    for(i in 0 until n) {
        if(a[i] != b[i]) ans++
    }

    print(ans)
}

