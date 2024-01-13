import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var n = readLine().toInt()
    var ans = 0

    while(true) {
        if(n < 10) break

        var tmp = 1
        while(n != 0) {
            tmp *= n % 10
            n /= 10
        }
        ans++
        n = tmp
    }

    print(ans)
}



