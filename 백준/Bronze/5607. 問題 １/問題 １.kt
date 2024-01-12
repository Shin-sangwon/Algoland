import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val tc = readLine().toInt()
    var a = 0
    var b = 0

    repeat(tc) {

        val (aa, bb) = readLine().split(" ").map { it.toInt() }

        if(aa == bb) {
            a += aa
            b += bb
        }else if(aa > bb) {
            a += aa + bb
        }else {
            b += aa + bb
        }
    }

    print("$a $b")

}



