import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer = 0

    for(i in 0 until 3) {
        if(arr[i] - n < 0) {
            answer += arr[i]
        }else {
            answer += n
        }
    }

    print(answer)

}
