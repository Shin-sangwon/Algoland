import java.io.BufferedReader
import java.io.InputStreamReader


lateinit var map: HashMap<Char, Char>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val(n, d) = readLine().split(" ").map { it.toInt() }
    map = HashMap()
    if(d == 1) {
        map['d'] = 'q';
        map['b'] = 'p';
        map['q'] = 'd';
        map['p'] = 'b';
    }else {
        map['d'] = 'b';
        map['b'] = 'd';
        map['q'] = 'p';
        map['p'] = 'q';
    }

    val sb = StringBuilder()
    repeat(n) {
        val str = readLine();
        for(c in str) {
            sb.append(map[c])
        }
        sb.append("\n")
    }

    print(sb)

}