
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (num, union, level) = br.readLine().split(" ").map { it.toInt() }

    if((num >= 1000) && (union >= 8000 || level >= 260)) {
        print("Very Good")
    }else if(num >= 1000) {
        print("Good")
    }else {
        print("Bad")
    }
}




