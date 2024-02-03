import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    print(calc(readLine()))
}

fun calc(str: String) : String {

    val set: HashSet<String> = HashSet()
    val arr = str.split(" ")

    for(c in arr) {
        if(set.contains(c)) {
            return "no"
        }else {
            set.add(c)
        }
    }

    return "yes"
}