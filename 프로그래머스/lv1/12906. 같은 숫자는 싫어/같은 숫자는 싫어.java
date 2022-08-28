import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        al.add(q.poll());
        
        while(!q.isEmpty()) {
            
            if(q.peek() == al.get(al.size() - 1)) {
                q.poll();
                continue;
            }
            
            al.add(q.poll());
        }
        
        int answer[] = new int[al.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}