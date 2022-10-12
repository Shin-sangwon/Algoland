import java.util.ArrayList;
import java.util.stream.Stream;

class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> al = new ArrayList<>();
        
        
        String sb = (new StringBuilder(String.valueOf(n)).reverse().toString());
        
        Stream.of(sb.split(""))
            .mapToInt(Integer::parseInt)
            .forEach(x -> al.add(x));
        
        int idx = 0;
        
        int answer[] = new int[al.size()];
        
        for(int x : al) {
            answer[idx] = x;
            idx++;
        }
        
        return answer;
    }
}