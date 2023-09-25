import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val arr1 = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val arr2 = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var answer = 0

    for(i in 0 until n) {
        if(arr1[i] <= arr2[i]) answer++
    }

    print(answer)
}

