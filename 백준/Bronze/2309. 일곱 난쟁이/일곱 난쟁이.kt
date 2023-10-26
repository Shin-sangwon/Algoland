import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

lateinit var arr: IntArray
lateinit var ans: IntArray
var flag = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    arr = IntArray(9)
    ans = IntArray(7)

    for(i in 0 until 9) {
        arr[i] = br.readLine().toInt()
    }

    recursive(0, 0)
    ans.sort()
    ans.forEach { println(it) }
}

fun recursive(cnt: Int, start: Int) {

    if(flag) return

    if(cnt == 7) {
        if(calc()) {
            flag = true
            return
        };
        return
    }

    for(i in start until 9) {
        ans[cnt] = arr[i]
        recursive(cnt + 1, i + 1)
        if(flag) return
    }

}

fun calc() : Boolean{
    return ans.sum() == 100
}
