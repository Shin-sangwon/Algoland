import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var answer = 0
    var tmp = 0

    for(i in arr.indices) {

        if(arr[i] == 0) {
            answer = max(answer, tmp)
            tmp = 0
        }else {
            tmp++
        }
    }

    if(tmp != 0) {
        answer = max(answer, tmp)
    }

    print(answer)
}


