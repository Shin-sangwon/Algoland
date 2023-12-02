import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var n = readLine().toInt()
    var answer = 1
    while(true) {

        if(n == 1) break

        answer++
        n = calc(n)


    }

    print(answer)
}

fun calc(n: Int): Int {

    return if(n % 2 == 0) funA(n) else funB(n)
}

fun funA(n: Int): Int {

    return n / 2
}

fun funB(n: Int) : Int {

    return 3 * n + 1
}


