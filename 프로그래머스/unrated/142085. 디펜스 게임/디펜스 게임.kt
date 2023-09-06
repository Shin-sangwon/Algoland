import java.util.*;

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer: Int = enemy.size
        val pq:PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
        
        var count = n
        var power = k
        
        run loop@{
        enemy.forEachIndexed {i, e -> 
            count -= e
            pq.add(e)
            
            if(count < 0) {              
                if(power > 0 && pq.isNotEmpty()) {
                    count += pq.poll()
                    power--
                }else {
                    answer = i
                    return@loop
                    }   
                }
            }
        }
        return answer
    }
}