import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val(n, h) = readLine().split(" ").map {it.toInt()}

    val up = IntArray(h + 1)
    val down = IntArray(h + 1)

    for(i in 0 until n) {
        val next = readLine().toInt()
        if(i % 2 == 0) up[next]++
        else down[next]++
    }

    for(i in h - 1 downTo 1) {
        up[i] += up[i + 1]
        down[i] += down[i + 1]
    }

    var answer = Int.MAX_VALUE
    var answerCount = 0

    for(i in 1..h) {
        val breakCount = up[i] + down[h - i + 1]
        if(breakCount < answer) {
            answer = breakCount
            answerCount = 1
        }else if(answer == breakCount){
            answerCount++
        }
    }

    print("$answer $answerCount")
}