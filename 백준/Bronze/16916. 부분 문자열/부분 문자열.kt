import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val s = readLine()
    val p = readLine()

    print(if(kmp(s, p)) "1" else "0")
}

fun kmp(s: String, p: String): Boolean {

    val pi = getPi(p)
    var j = 0
    for(i in s.indices) {
        while(j > 0 && s[i] != p[j]) {
            j = pi[j - 1]
        }

        if(s[i] == p[j]) {
            if(j == p.length - 1) return true
            else j++
        }
    }

    return false
}

fun getPi(p: String): IntArray {

    val pi = IntArray(p.length) { 0 }
    var j = 0

    for(i in 1 until p.length) {
        while(j > 0 && p[i] != p[j]){
            j = pi[j - 1]
        }
        if(p[i] == p[j]) {
            pi[i] = ++j
        }
    }

    return pi
}