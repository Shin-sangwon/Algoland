import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val input = br.readLine();
    when (input) {
        "SONGDO" -> print("HIGHSCHOOL")
        "CODE" -> print("MASTER")
        "2023" -> print("0611")
        else -> print("CONTEST")
    }
}
