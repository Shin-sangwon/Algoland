import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val max = IntArray(3)
    val min = IntArray(3)

    val preMax = IntArray(3)
    val preMin = IntArray(3)

    for(i in 0 until n) {
        val(f, s, t) = br.readLine().split(" ").map { it.toInt() }

        preMax[0] = max[0]
        preMax[1] = max[1]
        preMax[2] = max[2]

        preMin[0] = min[0]
        preMin[1] = min[1]
        preMin[2] = min[2]

        max[0] = maxOf(preMax[0], preMax[1]) + f
        max[1] = maxOf(preMax[0], maxOf(preMax[1], preMax[2])) + s
        max[2] = maxOf(preMax[1], preMax[2]) + t

        min[0] = minOf(preMin[0], preMin[1]) + f
        min[1] = minOf(preMin[0], minOf(preMin[1], preMin[2])) + s
        min[2] = minOf(preMin[1], preMin[2]) + t

    }

    val maxAnswer = maxOf(max[0], maxOf(max[1], max[2]))
    val minAnswer = minOf(min[0], minOf(min[1], min[2]))

    print("$maxAnswer $minAnswer")

}