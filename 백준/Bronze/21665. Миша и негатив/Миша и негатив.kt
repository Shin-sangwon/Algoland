import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map{it.toInt()}

    val arr = Array(n) {CharArray(m)}

    for(i in 0 until n) {
        arr[i] = br.readLine().toCharArray()
    }

    br.readLine()
    var answer = 0
    for(i in 0 until n) {
        val str = br.readLine()

        for(j in 0 until m) {
            if(arr[i][j] == str[j]) answer++
        }
    }

    print(answer)
}