class Solution {
    public int solution(int n) {
        boolean arr[] = new boolean[n+1];
        int answer = 0;
        for(int i = 2; i < arr.length; i++) {
            if(arr[i]) continue;
            for(int j = 2 * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
        
        for(int i = 2; i < arr.length; i++) {
            if(arr[i]) continue;
            answer++;
        }
        
        return answer;
    }
}