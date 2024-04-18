import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var visited: BooleanArray
lateinit var arr: CharArray
var n = 0

var maxValue = Long.MIN_VALUE
var minValue = Long.MAX_VALUE

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val k = readLine().toInt()
    n = k
    arr = readLine().trim().replace("\\s+".toRegex(), "").toCharArray()
    visited = BooleanArray(10)

    search("")

    var minValueForPrint = minValue.toString()

    if(minValueForPrint.length != n + 1) {
        minValueForPrint = "0$minValueForPrint"
    }

    println("$maxValue\n$minValueForPrint")
}

fun search(str: String) {
    val idx = str.length

    if(idx == n + 1) {

        if(str.toLong() > maxValue) {
            maxValue = str.toLong()
        }

        if(str.toLong() < minValue) {
            minValue = str.toLong()
        }

        return
    }

    for(i in 0..9) {
        if(visited[i]) continue

        var now = str
        if(str.isEmpty()) {
           visited[i] = true
           search(now + i.toString())
           visited[i] = false
        }else {
            val target = Character.getNumericValue(str[idx - 1])
            if(arr[idx - 1] == '<' && target < i) {
                visited[i] = true
                search(now + i.toString())
                visited[i] = false
            }else if(arr[idx - 1] == '>' && target > i) {
                visited[i] = true
                search(now + i.toString())
                visited[i] = false
            }
        }

    }
}