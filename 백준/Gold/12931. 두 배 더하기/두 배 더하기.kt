import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    var arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer = 0

    while(arr.sum() != 0) {
        answer++

        if(checkAllEven(arr)) {
            arr = arr.map {it / 2}.toIntArray()
        }else {
            val idx = arr.indexOfFirst {it % 2 != 0}
            arr[idx]--
        }
    }

    print(answer)

}

fun checkAllEven(arr: IntArray) : Boolean {

    return arr.none { it % 2 != 0 }
}



