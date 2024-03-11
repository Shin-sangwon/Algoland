import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val str = readLine()
    var target = ""

    for(i in 1 .. 10) {
        target += i.toString()
        if(target == str) {
            print(i)
            return@with
        }
    }

    print(-1)
}

