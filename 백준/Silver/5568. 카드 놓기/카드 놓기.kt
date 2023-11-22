import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

var n: Int = 0
var k: Int = 0
lateinit var arr: IntArray
lateinit var numbers: IntArray
lateinit var set: HashSet<Int>
lateinit var visited: BooleanArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    n = readLine().toInt()
    k = readLine().toInt()

    arr = IntArray(n)
    numbers = IntArray(k)
    visited = BooleanArray(n)
    set = HashSet()

    for(i in 0 ..< n) {
        arr[i] = readLine().toInt()
    }

    pick(0)
    print(set.size)
}

fun pick(count: Int) {

    if(count == k) {
        val number: Int = numbers.joinToString("").toInt()
        set.add(number)
        return
    }

    for(i in 0 ..< n) {

        if(visited[i]) continue
        visited[i] = true
        numbers[count] = arr[i]
        pick(count + 1)
        visited[i] = false

    }

}