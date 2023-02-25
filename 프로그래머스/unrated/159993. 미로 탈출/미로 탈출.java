import java.util.*;

class Node{
    int x;
    int y;
    int time;
    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        char[][] map = new char[maps.length][];
        boolean[][] visited = new boolean[maps.length][];
        Node start = null;
        
        for(int i = 0 ; i < maps.length; i++) {
            map[i] = new char[maps[i].length()];
            visited[i] = new boolean[maps[i].length()];
            for(int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') start = new Node(i, j, 0);
            }    
        }
        
        Node lever = findLever(map, start, visited);
        
        if(lever == null) return -1;
        
        for(boolean[] x : visited) {
            Arrays.fill(x, false);
        }
         
        return findDest(map, lever, visited);
    }
    
    public static Node findLever(char[][] map, Node start, boolean[][] visited) {
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        visited[start.x][start.y] = true;
        
        while(!queue.isEmpty()) {
            
            Node node = queue.poll();
            
            for(int k = 0; k < 4; k++) {
                int nx = dx[k] + node.x;
                int ny = dy[k] + node.y;
                
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[node.x].length) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;
                
                if(map[nx][ny] == 'L') {
                    return new Node(nx, ny, node.time + 1);
                }
                queue.add(new Node(nx, ny, node.time + 1));
                visited[nx][ny] = true;
            }
            
        }
        
        
        return null;
    }
    
    public static int findDest(char[][] map, Node start, boolean[][] visited) {
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        visited[start.x][start.y] = true;
        
        while(!queue.isEmpty()) {
            
            Node node = queue.poll();
            for(int k = 0; k < 4; k++) {
                int nx = dx[k] + node.x;
                int ny = dy[k] + node.y;
                
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[node.x].length) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;
                
                if(map[nx][ny] == 'E') {
                    return node.time + 1;
                }
                
                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, node.time + 1));
            }
        }
        
        return -1;
    }
}