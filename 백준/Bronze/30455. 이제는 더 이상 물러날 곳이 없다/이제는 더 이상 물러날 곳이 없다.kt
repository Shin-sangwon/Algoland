import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt().let {
        if(it % 2 == 0) {
            print("Duck")
        }else {
            print("Goose")
        }
    }
}


