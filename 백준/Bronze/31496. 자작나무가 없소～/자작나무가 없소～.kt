import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val arr = readLine().split(" ")
    val n = arr[0].toInt()
    val idx = arr[1]

    var answer = 0
    repeat(n) {
        val input = readLine().split(" ")
        val words = input[0].split("_")

        for(word in words) {
            if(word == idx) {
                answer += input[1].toInt()
                break
            }
        }
    }

    print(answer)
}