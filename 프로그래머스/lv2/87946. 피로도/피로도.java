import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        dfs(k, dungeons, new boolean[dungeons.length], 0);
        
        return answer;
    }
    
    private static void dfs(int k, int[][] arr, boolean[] visited, int cnt) {
        
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i] && arr[i][0] <= k) {
                visited[i] = true;
                dfs(k - arr[i][1], arr, visited, cnt + 1);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, cnt);
    }
    
    
}