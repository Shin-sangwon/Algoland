import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder();

    val idx = mutableListOf(
        "Never gonna give you up",
        "Never gonna let you down",
        "Never gonna run around and desert you",
        "Never gonna make you cry",
        "Never gonna say goodbye",
        "Never gonna tell a lie and hurt you",
        "Never gonna stop"
    )

    val n = br.readLine().toInt()

    for(i in 0 until n) {
        if(!idx.contains(br.readLine())) {
            sb.append("Yes")
            break;
        }
    }

    if(sb.isEmpty()) sb.append("No")

    print(sb)
}




