import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //상, 하, 좌, 우
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Node{
        int x;
        int y;
        int time;
        int speed;
        int direction;

        public Node(int x, int y, int time, int speed, int direction) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.speed = speed;
            this.direction = direction;

        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //x, y, speed, direction
        boolean[][][][] visited = new boolean[n][n][100][4];
        Queue<Node> queue = new LinkedList<>();
        int answer = Integer.MAX_VALUE;

        queue.add(new Node(0, 0, 0, 0, -1));

        while(!queue.isEmpty()) {

            Node node = queue.poll();

            if(node.x == n-1 && node.y == n-1) {
                answer = Math.min(answer, node.time);
                break;
            }

            for(int k = 0; k < 4; k++) {

                int newSpeed = node.direction == k? node.speed + 1 : 1;

                int nx = node.x + dx[k] * newSpeed;
                int ny = node.y + dy[k] * newSpeed;

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if(arr[nx][ny] < node.time + 1 && arr[nx][ny] != 0) continue;

                if(visited[nx][ny][newSpeed][k]) continue;

                // 지나갈 수 있는지 여부
                boolean canVisit = true;

                for(int x = node.x, y = node.y; x <= nx && y <= ny ; x += dx[k], y += dy[k]) {
                    if(arr[x][y] < node.time + 1 && arr[x][y] != 0) {
                        canVisit = false;
                        break;
                    }
                }

               if(canVisit) {
                   queue.add(new Node(nx, ny, node.time + 1, newSpeed, k));
                   visited[nx][ny][newSpeed][k] = true;
               }

            }
        }

        System.out.println(answer == Integer.MAX_VALUE? "Fired" : answer);
    }
}
