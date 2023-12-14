import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal
import java.math.RoundingMode


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val(n, m) = readLine().split(" ").map {it.toDouble()}

    val ans = BigDecimal(n / m).setScale(3, RoundingMode.HALF_UP).toDouble()

    val characterType = when {
        ans < 0.2 -> "weak"
        ans < 0.4 -> "normal"
        ans < 0.6 -> "strong"
        else -> "very strong"
    }

    print(characterType)

}