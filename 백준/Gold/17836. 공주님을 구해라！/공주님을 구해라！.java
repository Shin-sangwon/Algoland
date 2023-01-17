import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int[][] visited;
    static int n,m;

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Node() {

        }
    }

    private static int calc(boolean flag, int[][] visited, Node gram) {

        //그람을 먹었다면
        if(flag) {
            //그람을 먹었을 때 원래 도달할 수 없는 곳이라면
            if(visited[n-1][m-1] == 0) {
                return visited[gram.x][gram.y] + Math.abs(gram.x - (n-1)) + Math.abs(gram.y - (m - 1));
            }
            //그람도 먹고, 도달할 수 있는 곳이라면
            return Math.min(visited[n-1][m-1], visited[gram.x][gram.y] + Math.abs(gram.x - (n-1)) + Math.abs(gram.y - (m - 1)));
        }

        //그람을 못먹었다면
        return visited[n-1][m-1] == 0? -1 : visited[n-1][m-1];

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        final int T = Integer.parseInt(st.nextToken());
        Node gram = new Node();
        map = new int[n][m];
        //공주는 n,m에있음
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    //그람 위치 저장
                    gram = new Node(i, j);
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        visited = new int[n][m];
        queue.add(new Node(0, 0));
        int answer = 0;


        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if((nx < 0 || ny < 0 || nx >= n || ny >= m) || visited[nx][ny] != 0 || map[nx][ny] == 1) continue;

                queue.add(new Node(nx, ny));
                visited[nx][ny] = visited[node.x][node.y] + 1;

            }
        }

        /*
            1. 그람을 먹을 수 있는지?
            2. 그람을 먹고 도달한 시간
            3. 그람을 안먹고 도달한 시간
            4. 그냥 도달 못함
         */

        boolean flag = visited[gram.x][gram.y] != 0;
        answer = calc(flag, visited, gram);
        
        //도달 불가능
        if(answer == -1) {
            bw.write("Fail");
            //도달은 가능하다면
        }else{
            //t보다 크거나 같다면
            if(answer > T) {
                bw.write("Fail");
            }else{
                bw.write(String.valueOf(answer));
            }
        }

        bw.flush();
        bw.close();
        br.close();


    }


}