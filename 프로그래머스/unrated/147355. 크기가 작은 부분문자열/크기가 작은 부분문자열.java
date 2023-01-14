class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i = 0; i <= t.length() - p.length(); i++) {
            long tmp = Long.parseLong(t.substring(i, i+p.length()));
            
            if(tmp > Long.parseLong(p)) continue;
            
            answer++;
        }
        
        return answer;
    }
}