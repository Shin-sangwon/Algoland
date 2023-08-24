import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    when(br.readLine()) {
        "M" -> print("MatKor")
        "W" -> print("WiCys")
        "C" -> print("CyKor")
        "A" -> print("AlKor")
        else -> print("\$clear")
    }


}


