import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> process = new LinkedList<>();
        Queue<Integer> speed = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            process.add(progresses[i]);
            speed.add(speeds[i]);
        }
        
        while(!process.isEmpty()) {
            
            if(process.peek() < 100) {
                
                int n = process.size();
                
                while(n-->0) {
                    
                     process.add(process.poll() + speed.peek());
                     speed.add(speed.poll());
                    
                }
                
                continue;
            }
            
            int tmp = 0;
            
            while(true) {

                    if(process.isEmpty()) {
                        break;
                    }

                    if(process.peek() >= 100) {
                        process.poll();
                        speed.poll();
                        tmp++;
                        continue;
                    }

                    break;

                }
            
            ans.add(tmp);
            
        }
        int size = ans.size();
        int answer[] = new int[size];
        for(int i = 0; i < size; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}