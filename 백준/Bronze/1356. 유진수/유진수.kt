import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine()

    for(i in 0 until n.length - 1) {

        val first = n.subSequence(0, i + 1)
        val second = n.subSequence(i + 1, n.length)

        var a = 1
        var b = 1

        for(c in first) {
            a *= Character.getNumericValue(c)
        }

        for(c in second) {
            b *= Character.getNumericValue(c)
        }

        if(a == b) {
            print("YES")
            return
        }
    }

    print("NO")

}