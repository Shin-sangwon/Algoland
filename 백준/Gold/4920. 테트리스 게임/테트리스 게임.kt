import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

val blocks = arrayOf(
    arrayOf (Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(0, 3)),
    arrayOf (Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0)),
    arrayOf (Pair(0, 1), Pair(1, 0), Pair(1, 1), Pair(2, 0)),
    arrayOf (Pair(2, 0), Pair(0, 1), Pair(1, 1), Pair(2, 1)),
    arrayOf (Pair(0, 0), Pair(1, 0), Pair(1, 1), Pair(1, 2)),
    arrayOf (Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(2, 0)),
    arrayOf (Pair(1, 0), Pair(0, 1), Pair(1, 1), Pair(2, 1)),
    arrayOf (Pair(0, 1), Pair(1, 0), Pair(1, 1), Pair(1, 2)),
    arrayOf (Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(1, 1)),
    arrayOf (Pair(0, 0), Pair(0, 1), Pair(1, 1), Pair(1, 2)),
    arrayOf (Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 2)),
    arrayOf (Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 1)),
    arrayOf (Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(1, 1))
)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val sb = StringBuilder()
    var idx = 1

    while(true) {
        val n = readLine().trim().toInt()
        if(n == 0) break
        var max = Int.MIN_VALUE
        val arr = Array (n) {IntArray (n)}

        for(i in 0 until n) {
            arr[i] = readLine().split("\\s+".toRegex()).filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
        }

        for(i in 0 until n) {

            for(j in 0 until n) {

                Loop@for(k in blocks.indices) {
                    var tmp = 0
                    for(l in blocks[k].indices) {
                        val nx = i + blocks[k][l].first
                        val ny = j + blocks[k][l].second

                        if(nx !in 0 until n || ny !in 0 until n) continue@Loop

                        tmp += arr[nx][ny]
                    }

                    max = max(max, tmp)
                }
            }
        }
        sb.append("${idx++}. $max\n")
    }

    print(sb)

}