import kotlin.math.*;

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val index = intArrayOf(6, 6, 5, 4, 3, 2, 1)
        var count = 0
        var zeroCount = 0
        
        for(lotto in lottos) {
            if(lotto == 0) {
                zeroCount++
                continue
            }
            
            if(win_nums.asSequence().any {it == lotto}) count++
        }
        
        var max = count + zeroCount
        if(max > 6) max = 6 
        val min = count
        val ans = intArrayOf(index[max], index[min]);
        return ans
    }
}