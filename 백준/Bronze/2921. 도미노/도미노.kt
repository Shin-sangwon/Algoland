import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    var ans = 0

    for(i in 0 .. n) {
        for(j in i .. n) {
            ans += i
            ans += j
        }
    }

    print(ans)

}