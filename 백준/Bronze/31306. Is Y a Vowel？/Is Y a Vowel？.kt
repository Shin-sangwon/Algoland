import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val str = readLine()

    var ans1 = 0
    var ans2 = 0

    for(c in str) {
        if(funA(c)) ans1++
        if(funB(c)) ans2++
    }

    print("$ans1 $ans2")

}

fun funA(c: Char) : Boolean {

    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}

fun funB(c: Char) : Boolean {

    return funA(c) || c == 'y'
}