import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var a = -1
    var b = -1

    for(i in 1 .. 9) {

        println("? A $i")
        val aa = readLine().toInt()
        if(aa == 1) a = i

        println("? B $i")
        val bb = readLine().toInt()
        if(bb == 1) b = i

        if(a != -1 && b != -1) break

    }

    println("! ${a + b}")

}