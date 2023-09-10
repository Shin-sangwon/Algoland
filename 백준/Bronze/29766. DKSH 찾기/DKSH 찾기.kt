import java.io.BufferedReader
import java.io.InputStreamReader

const val INDEX = "DKSH"
const val LENGTH = INDEX.length

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val str = br.readLine()
    var answer = 0

    for(i in 0 .. str.length - LENGTH) {
        
        if(str.substring(i, i + LENGTH) == INDEX)  {
            answer++
        }
    }

    print(answer)
}




