import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val answer = getScoreBoard()[readLine().toInt()]
    print("${answer!!.first} ${answer.second}")
}

fun getScoreBoard() : HashMap<Int, Pair<Int, Int>> {
    val map: HashMap<Int, Pair<Int, Int>> = HashMap()
    map[1] = Pair(12, 1600)
    map[2] = Pair(11, 894)
    map[3] = Pair(11, 1327)
    map[4] = Pair(10, 1311)
    map[5] = Pair(9, 1004)
    map[6] = Pair(9, 1178)
    map[7] = Pair(9, 1357)
    map[8] = Pair(8, 837)
    map[9] = Pair(7, 1055)
    map[10] = Pair(6, 556)
    map[11] = Pair(6, 773)
    return map
}