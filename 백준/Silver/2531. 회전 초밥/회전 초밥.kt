import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
        val (n, d, k, c) = readLine().split(" ").map { it.toInt() }
        val sushi = IntArray(n) { readLine().toInt() }

        val dishCount = IntArray(d + 1)
        var count = 0
        var maxCount = 0

        for (i in 0 until k) {
            if (dishCount[sushi[i]] == 0) count++
            dishCount[sushi[i]]++
        }

        for (i in 0 until n) {
            if (maxCount <= count) {
                if (maxCount < count) maxCount = count
                if (dishCount[c] == 0) maxCount++
            }

            dishCount[sushi[i]]--
            if (dishCount[sushi[i]] == 0) count--

            val nextIndex = (i + k) % n
            if (dishCount[sushi[nextIndex]] == 0) count++
            dishCount[sushi[nextIndex]]++
        }

        println(maxCount)
}


