import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }
        
        for(int i = 0; i < completion.length; i++) {
            if(!map.containsKey(completion[i])) {
                answer = completion[i];
                break;
            }
            
            map.put(completion[i], map.get(completion[i]) - 1);
        }
        
        
        if(answer.equals("")) {
            for(String x : map.keySet()) {
                if(map.get(x) != 0) {
                    answer = x;
                }
            }
        }

        return answer;
        
    }
}
