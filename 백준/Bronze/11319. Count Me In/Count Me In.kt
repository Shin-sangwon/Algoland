import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val str = readLine()

        var a = 0
        var b = 0
        for(c in str) {
            if(c.isWhitespace()) continue

            if(isVowel(c)) b++
            else a++
        }

        sb.append("$a $b\n")

    }

    print(sb)
}

private fun isVowel(c: Char) : Boolean {

    val tmp = c.lowercaseChar()
    return tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u'
}