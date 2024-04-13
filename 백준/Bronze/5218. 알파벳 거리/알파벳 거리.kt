import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n) {
        val (str1, str2) = readLine().split(" ")
        sb.append("Distances: ")

        for(i in str1.indices) {
            val idx = str1[i].code - str2[i].code
            if(idx <= 0) sb.append("${idx * -1} ")
            else sb.append("${str2[i].code + 26 - str1[i].code} ")
        }
        sb.append("\n")
    }

    print(sb)

}
