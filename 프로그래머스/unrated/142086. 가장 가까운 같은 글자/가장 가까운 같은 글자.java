import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        // 'a' 97
        int[] answer = new int[s.length()]; 
        int index[] = new int[26];
        Arrays.fill(index, -1);
        for(int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            
            
            if(index[tmp-97] == -1) {
                answer[i] = -1;
            }else {
                answer[i] = i - index[tmp-97];
            }
            
            index[tmp-97] = i;
            
        }
        return answer;
    }
}