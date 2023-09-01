import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs

var n = 0
val br = BufferedReader(InputStreamReader(System.`in`))
var answer = Int.MAX_VALUE
lateinit var arr: IntArray
lateinit var node: Pair<Int, Int>

fun main() {

    init()
    calc()

    print("${node.first} ${node.second}")
}

fun init() {
    n = br.readLine().toInt()
    arr = IntArray(n)
    val st = StringTokenizer(br.readLine())

    for(i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }
}

fun calc() {

    var left = 0
    var right = n-1

    while(left < right) {
        val value = arr[left] + arr[right]

        if(value == 0) {
            node = Pair(arr[left], arr[right])
            return
        }

        if(abs(value) < answer) {
            node = Pair(arr[left], arr[right])
            answer = abs(value)
        }

        if(value < 0) {
            left++
        }else if(value > 0) {
            right--
        }
    }
}


