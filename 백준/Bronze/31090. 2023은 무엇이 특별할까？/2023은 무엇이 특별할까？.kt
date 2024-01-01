import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n) {
        val flag = calc(readLine().toInt())
        if(flag) {
            sb.append("Good\n")
        }else {
            sb.append("Bye\n")
        }
    }

    print(sb)

}

fun calc(n: Int): Boolean{

    val idx = n % 100
    if((n + 1) % idx == 0) return true

    return false
}


