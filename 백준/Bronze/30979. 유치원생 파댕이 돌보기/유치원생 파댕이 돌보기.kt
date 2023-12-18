import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val t = readLine().toInt()
    val n = readLine().toInt()
    val sum = readLine().split(" ").sumOf { it.toInt() }
    
    val ans = if(sum >= t) {
        "Padaeng_i Happy"
    }else {
        "Padaeng_i Cry"
    }

    print(ans)
}