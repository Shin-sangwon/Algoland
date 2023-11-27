import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val pq = PriorityQueue<Pair<Int, Int>>() {o1, o2 -> o2.first - o1.first}
    val visited = BooleanArray(10001)
    repeat(n) {
        val pair = readLine().split(" ").let { (o1, o2) -> Pair(o1.toInt(), o2.toInt()) }
        pq.add(pair)
    }

    var answer = 0


    Loop@ while(pq.isNotEmpty()) {
        val pair = pq.poll()

        if(visited[pair.second]) {

            for(i in pair.second - 1 downTo 1) {
                if(!visited[i]) {
                    visited[i] = true
                    answer += pair.first
                    continue@Loop
                }
            }

            continue@Loop
        }

        visited[pair.second] = true
        answer += pair.first

    }

    print(answer)
}