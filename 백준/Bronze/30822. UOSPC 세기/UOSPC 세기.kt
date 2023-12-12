import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val str = readLine()

    val map = mutableMapOf<Char, Int>()

    for(c in str) {
        map[c] = map.getOrDefault(c, 0) + 1
    }

    val answer = listOf('u', 'o', 's', 'p', 'c').minOfOrNull { map.getOrDefault(it, 0) } ?: 0
    print(answer)
}

