import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int[][] arr;
    static int[][] visited;

    static class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nowX = Integer.parseInt(st.nextToken());
        int nowY = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new int[n][n];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(nowX ,nowY));

        while(!queue.isEmpty()) {

            if(visited[targetX][targetY] != 0) break;

            Node node = queue.poll();
            for(int k = 0; k < dx.length; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if((nx < 0 || ny < 0 || nx >= n || ny >= n) || visited[nx][ny] != 0) continue;

                queue.add(new Node(nx, ny));
                visited[nx][ny] = visited[node.x][node.y] + 1;

            }
        }

        bw.write(visited[targetX][targetY] == 0? "-1" : String.valueOf(visited[targetX][targetY]));
        bw.flush();
        bw.close();
        br.close();


    }
}