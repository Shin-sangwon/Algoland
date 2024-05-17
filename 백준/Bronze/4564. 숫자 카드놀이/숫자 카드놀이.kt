import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val sb = StringBuilder()

    while(true) {
        var n = readLine().toInt()

        if(n == 0) break

        val numbers: ArrayList<Int> = ArrayList()
        numbers.add(n)

        while(n >= 10) {
            var tmp = 1
            val str = n.toString()
            for(c in str) {
                tmp *= Character.getNumericValue(c)
            }

            numbers.add(tmp)
            n = tmp
        }

        sb.append("${numbers.joinToString(" ")}\n")

    }

    print(sb)
}