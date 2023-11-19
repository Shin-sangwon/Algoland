import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    when (br.readLine().toInt()) {
        in 380 until 425 -> print("Violet")
        in 425 until 450 -> print("Indigo")
        in 450 until 495 -> print("Blue")
        in 495 until 570 -> print("Green")
        in 570 until 590 -> print("Yellow")
        in 590 until 620 -> print("Orange")
        else -> print("Red")
    }
}



