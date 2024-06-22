import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var ans = ""
    var idx = 0
    repeat(7) {
        val(n, m) = readLine().split(" ")
        val number = m.toInt()

        if(number > idx) {
            idx = number
            ans = n
        }
    }

    print(ans)

}