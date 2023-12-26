import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));
    val n = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val (x, y, z) = br.readLine().split(" ").map {it.toInt()}
        var ans = 0

        for(i in 1..x) {
            for(j in 1..y) {
                for(k in 1..z) {
                    if((i % j == j % k) && (j % k == k % i) && (k % i == i % j)) ans++
                }
            }

        }
        sb.append("$ans\n")
    }

    print(sb)
}



