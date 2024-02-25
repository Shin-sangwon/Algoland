import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, k) = readLine().split(" ").map { it.toInt() }
    val jewels: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy({it.first}, {-it.second}))
    val backpacks = IntArray(k)
    val candidates: PriorityQueue<Int> = PriorityQueue(reverseOrder<Int>())

    for(i in 0 until n) {
        val pair = readLine().split(" ").map { it.toInt() }.let { (a, b) -> Pair(a, b) }
        jewels.add(pair)
    }

    for(i in 0 until k) {
        backpacks[i] = readLine().toInt()
    }
    backpacks.sort()
    var ans: Long = 0

    for(i in backpacks.indices) {
        val target = backpacks[i]

        while(jewels.isNotEmpty() && jewels.peek().first <= target) {
            candidates.add(jewels.poll().second)
        }

        if(candidates.isNotEmpty()) ans += candidates.poll()
    }

    print(ans)
}