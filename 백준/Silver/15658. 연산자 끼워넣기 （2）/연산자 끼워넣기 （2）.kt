import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

lateinit var arr:IntArray
lateinit var operator: IntArray
var maxValue = Int.MIN_VALUE
var minValue = Int.MAX_VALUE

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    arr = readLine().split(" ").map {it.toInt()}.toIntArray()
    operator = readLine().split(" ").map { it.toInt() }.map { it.toInt().coerceAtMost(n - 1) }.toIntArray()

    search(arr[0], 1)

    print("$maxValue\n$minValue")
}

fun search(value: Int, idx: Int) {

    if(idx == arr.size) {
        maxValue = max(maxValue, value)
        minValue = min(minValue, value)

        return
    }

    for(i in 0 until 4) {

        if(operator[i] == 0) continue
        operator[i]--
        when (i) {
            0 -> {
                search(value + arr[idx], idx + 1)
            }
            1 -> {
                search(value - arr[idx], idx + 1)
            }
            2 -> {
                search(value * arr[idx], idx + 1)
            }
            else -> {
                search(value / arr[idx], idx + 1)
            }
        }
        operator[i]++
    }


}