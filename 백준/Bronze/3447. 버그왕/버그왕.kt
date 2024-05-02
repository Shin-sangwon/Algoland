import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var str: String?
    val sb = StringBuilder()
    while(readLine().also { str = it } != null) {
        while(str!!.contains("BUG")) {
            str = str!!.replace("BUG", "")
        }
        sb.append("$str\n")
    }

    print(sb)
}
