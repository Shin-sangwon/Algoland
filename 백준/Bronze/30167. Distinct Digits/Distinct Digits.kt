import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val(n, m) = br.readLine().split(" ").map { it.toInt() }

    var answer = -1

    for(x in n..m) {
        var idx = 1

        if(x in 10..99) {
            idx = 2
        }else if(x in 100..999) {
            idx = 3
        }else if(x in 1000..9999) {
            idx = 4
        }else if(x in 10000..99999) {
            idx = 5
        }else if(x >= 100000) {
            idx = 6
        }

        val set: Set<Char> = x.toString().toSet()

        if(idx == set.size) {
            answer = x
            break
        }
    }

    print(answer)
}
