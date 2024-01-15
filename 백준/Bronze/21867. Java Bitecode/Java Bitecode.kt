import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val str = readLine()
    val sb = StringBuilder()

    for(c in str) {
        if(c == 'J' || c == 'A' || c == 'V') continue
        sb.append(c)
    }

    if(sb.isEmpty()) {
        print("nojava")
    }else {
        print(sb)
    }
}



