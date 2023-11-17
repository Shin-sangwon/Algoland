import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val s = readLine()
    var t = readLine()

    while (s.length < t.length) {
        t = calculator(t)
    }

    if(s == t) print(1) else print(0)

}

fun calculator(str: String): String {

    return if (str[str.length - 1] == 'A') {
        str.substring(0, str.length - 1)
    } else {
        str.substring(0, str.length - 1).reversed()
    }
}