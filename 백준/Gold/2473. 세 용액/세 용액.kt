import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

var sum = Long.MAX_VALUE
var n = 0
lateinit var arr:LongArray
lateinit var answer: Triple<Long, Long, Long>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    arr = LongArray(n)

    val st = StringTokenizer(br.readLine())
    for(i in 0 until n) arr[i] = st.nextToken().toLong()

    arr.sort()
    calc()

    print("${answer.first} ${answer.second} ${answer.third}")
}

fun calc() {

    for(i in 0 until n - 2) {

        var left = i + 1
        var right = n - 1

        while(left < right) {
            val value: Long = arr[i] + arr[left] + arr[right]
            if(value == 0L) {
                answer = Triple(arr[i], arr[left], arr[right])
                return
            }

            if(abs(value) < sum) {
                sum = abs(value)
                answer = Triple(arr[i], arr[left], arr[right])
            }

            if(value < 0) {
                left++
            }else {
                right--
            }
        }
    }
}