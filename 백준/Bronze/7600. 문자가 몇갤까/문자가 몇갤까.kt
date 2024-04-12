import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Locale

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val sb = StringBuilder()

    while(true) {
        val str = readLine().uppercase(Locale.getDefault())

        if(str == "#") break

        val set:HashSet<Char> = HashSet()

        for(c in str) {
            if(c in 'A'..'Z') set.add(c)
        }

        sb.append("${set.size}\n")
    }

    print(sb)

}