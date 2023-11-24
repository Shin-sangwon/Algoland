import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue


data class Alphabet(val character:Char, val score: Int) : Comparable<Alphabet> {
    override fun compareTo(other: Alphabet): Int {
        return other.score - this.score
    }

}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr: Array<String> = Array(n) {""}
    val map: HashMap<Char, Int> = HashMap()

    for(i in 0..< n) {
        arr[i] = readLine()
        val length = arr[i].length
        for(j in 0 ..< length) {

            val now = arr[i][j]
            map[now] = map.getOrDefault(now, 0) + (pow(10, length - j - 1))
        }
    }

    val pq = PriorityQueue<Alphabet>()

    for(key in map.keys) {
        val alpha = Alphabet(key, map[key]!!)
        pq.add(alpha)
    }
    var idx = 9
    val index = HashMap<Char, Int>()
    while(pq.isNotEmpty()) {
        val alpha = pq.poll()
        index[alpha.character] = idx--
    }

    var answer = 0

    for(i in arr.indices) {
        val sb = StringBuilder()
        for(word in arr[i]) {
            sb.append(index[word])
        }
        answer += sb.toString().toInt()
    }

    print(answer)
}

fun pow(base: Int, exponent: Int): Int {
    var result = 1
    repeat(exponent) {
        result *= base
    }
    return result
}