import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n)

    for(i in 0 ..< n) {
        arr[i] = readLine().toInt()
    }

    arr.sort()

    var start = 1
    var end = arr.last() - arr.first()
    var answer = 0

    while(start <= end) {
        val mid = (start + end) / 2

        if(calc(arr, m, mid)) {
            answer = mid
            start = mid + 1
        }else {
            end = mid - 1
        }
    }

    print(answer)

}

fun calc(arr: IntArray, k: Int, location: Int) : Boolean{

    var count = 1
    var last = arr[0]

    for(i in arr.indices) {
        if(arr[i] - last >= location) {
            count++
            last = arr[i]
        }
    }

    return count >= k
}
