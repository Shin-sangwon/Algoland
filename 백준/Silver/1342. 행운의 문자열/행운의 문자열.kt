import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var str: String
lateinit var alphabet: IntArray
var answer = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    str = readLine()
    alphabet = IntArray(26)
    for(c in str) {
        alphabet[c - 'a']++
    }
    backTracking(0, ' ')
    println(answer)
}

fun backTracking(idx: Int, visited: Char) {

    if(str.length == idx) {
        answer++
        return
    }

    for(i in alphabet.indices) {
        if(alphabet[i] == 0) continue

        if(visited.code == i + 'a'.code) continue

        alphabet[i]--
        backTracking(idx + 1, (i + 'a'.code).toChar())
        alphabet[i]++
    }
}