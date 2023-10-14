import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val str = br.readLine()
    val idx = "kick"
    var answer = 0

    for(i in 0..str.length - 4) {
        if(str.substring(i, i + 4) == idx) {
            answer++
        }
    }

    print(answer)
    
}