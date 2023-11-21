import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

lateinit var arr: Array<IntArray>
lateinit var numbers: IntArray
var n = 0
var answer = Int.MAX_VALUE

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    n = readLine().toInt()
    arr = Array(n) {IntArray(n)}
    numbers = IntArray(n / 2)

    for(i in 0..< n) {
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    combination(0, 0)

    print(answer)
}

fun combination(start: Int, cnt: Int) {

    if(cnt == n / 2) {
        makeTeam()
        return
    }

    for(i in start..< n ) {
        numbers[cnt] = i
        combination(i + 1, cnt + 1)
    }
}

fun makeTeam() {

    val teamA = numbers
    val teamB = IntArray(numbers.size)
    var idx = 0

    for(i in 0 ..< n) {
        if(i !in teamA) {
            teamB[idx] = i
            idx++
        }
    }

    calculationSynergy(teamA, teamB)

}

fun calculationSynergy(teamA: IntArray, teamB: IntArray) {

    var aScore = 0
    var bScore = 0

    for(i in teamA.indices) {
        for(j in teamA.indices) {
            if(i == j) continue
            aScore += arr[teamA[i]][teamA[j]]
        }
    }

    for(i in teamB.indices) {
        for(j in teamB.indices) {
            if(i == j) continue
            bScore += arr[teamB[i]][teamB[j]]
        }
    }

    answer = min(answer, abs(aScore - bScore))
}