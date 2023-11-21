import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

val a = intArrayOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3 ,3, 4)
val b = intArrayOf(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5)
lateinit var win: IntArray
lateinit var draw: IntArray
lateinit var lose: IntArray
var flag = false

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val sb = StringBuilder()

    repeat(4) {
        val st = StringTokenizer(readLine())
        win = IntArray(6)
        draw = IntArray(6)
        lose = IntArray(6)

        for (i in 0..<6) {
            win[i] = st.nextToken().toInt()
            draw[i] = st.nextToken().toInt()
            lose[i] = st.nextToken().toInt()
        }
        val scores = win.sum() + draw.sum() + lose.sum()
        if (scores != 30) {
            sb.append("0\n")
            return@repeat
        }

        backtracking(0)

        if(flag) {
            sb.append("1\n")
            flag = false
        }else {
            sb.append("0\n")
        }
    }

    print(sb)
}

fun backtracking(round: Int) {

    if(round == 15 || flag) {
        flag = true
        return
    }

    val teamA = a[round]
    val teamB = b[round]
    // a승
    if(win[teamA] > 0 && lose[teamB] > 0) {
        win[teamA]--
        lose[teamB]--
        backtracking(round + 1)
        win[teamA]++
        lose[teamB]++
    }
    // 무승부
    if(draw[teamA] > 0 && draw[teamB] > 0) {
        draw[teamA]--
        draw[teamB]--
        backtracking(round + 1)
        draw[teamA]++
        draw[teamB]++
    }
    // a패
    if(win[teamB] > 0 && lose[teamA] > 0) {
        win[teamB]--
        lose[teamA]--
        backtracking(round + 1)
        win[teamB]++
        lose[teamA]++
    }


}