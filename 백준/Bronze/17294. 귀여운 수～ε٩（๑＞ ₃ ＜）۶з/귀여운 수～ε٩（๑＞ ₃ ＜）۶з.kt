import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {


    val longArray = readLine().map { it.toString().toLong() }.toLongArray()
    val right = "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!"
    val wrong = "흥칫뿡!! <(￣ ﹌ ￣)>"

    if(longArray.size in 1..2) {
        print(right)
        return@with
    }

    val idx = longArray[1] - longArray[0]

    for(i in 1 until longArray.size - 1) {
        val tmp = longArray[i + 1] - longArray[i]
        if(idx != tmp) {
            print(wrong)
            return@with
        }
    }

    print(right)


}