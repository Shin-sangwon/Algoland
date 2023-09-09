import java.io.BufferedReader
import java.io.InputStreamReader

const val INDEX = "WelcomeToSMUPC"
const val LENGTH = INDEX.length

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    print(INDEX[(n - 1) % LENGTH])

}




