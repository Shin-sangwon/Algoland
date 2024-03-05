import java.util.*;

class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
    var answer: Int = 0
    var count = 0
    val map:HashMap<Int, Int> = HashMap();

    for(i in tangerine) {
        map[i] = map.getOrDefault(i, 0) + 1
    }

    val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareByDescending { it.second })

    for (entry in map.entries) {
        pq.add(entry.key to entry.value)
    }

    while(pq.isNotEmpty()) {
        val pair = pq.poll()
        answer++
        count += pair.second

        if(count >= k) break
    }

    return answer
    }

}