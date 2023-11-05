import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

lateinit var arr: IntArray


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (h, w) = br.readLine().split(" ").map {it.toInt()}
    arr = br.readLine().split(" ").map{it.toInt()}.toIntArray()

    var answer = 0

    for(i in 1 until w) {

        val left = getLeft(i)
        val right = getRight(i)

        val max = min(left, right)
        if(max > arr[i]) {
            answer += max - arr[i]
        }
    }

    print(answer)

}

fun getLeft(start: Int): Int {

    var now = 0

    for(i in start-1 downTo 0) {
        if(arr[i] > now) {
            now = arr[i]
        }
    }

    return now

}

fun getRight(start: Int): Int {

    var now = 0

    for(i in start until arr.size) {
        if(arr[i] > now) {
            now = arr[i]
        }
    }

    return now
}


