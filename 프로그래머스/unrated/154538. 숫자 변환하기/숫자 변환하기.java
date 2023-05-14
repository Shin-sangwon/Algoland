import java.util.*;

class Solution {
    
    class Node{
        int value;
        int cnt;
        public Node(int value, int cnt){
            this.value = value;
            this.cnt = cnt;
        }
    }
    
    public int bfs(int x, int y, int n) {
            
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[100_000_1];
        int cnt = 0;
        queue.add(new Node(x, 0));
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.value == y) {
                return node.cnt;
            }
            
            if(node.value * 2 <= 100_000_0 && !visited[node.value * 2]) {
                
                visited[node.value * 2] = true;
                queue.add(new Node((node.value * 2), node.cnt + 1));
            }
            
            if(node.value * 3 <= 100_000_0 && !visited[node.value * 3]) {
                
                visited[node.value * 3] = true;
                queue.add(new Node((node.value * 3), node.cnt + 1));
            }
            
            if(node.value + n <= 100_000_0 && !visited[node.value + n]) {
                
                visited[node.value + n] = true;
                queue.add(new Node((node.value + n), node.cnt + 1));
            }
            
            
        }
        
        
        
        return -1;
    }
    
    public int solution(int x, int y, int n) {
        int answer = bfs(x, y, n);
        
        
        return answer;
    }
}