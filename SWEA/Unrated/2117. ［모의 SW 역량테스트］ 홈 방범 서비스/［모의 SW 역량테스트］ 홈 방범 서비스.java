import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int price;
    static int cost;
    static int answer;

    static class Node{
        int x;
        int y;
        int length;
        public Node(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    private static void bfs(int x, int y, int length) {
        int houseCount = 0;

        Node start = new Node(x, y, 0);
        visited[x][y] = true;
        if(map[x][y] == 1) houseCount += 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int k = 0; k < 4; k++) {

                int nx = dx[k] + node.x;
                int ny = dy[k] + node.y;

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if(visited[nx][ny]) continue;

                if(node.length + 1 >= length) continue;

                visited[nx][ny] = true;

                if(map[nx][ny] == 1) houseCount += 1;

                queue.add(new Node(nx, ny, node.length+1));
            }

        }

        if(houseCount * price >= cost) {

            answer = Math.max(answer, houseCount);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int printIndex = 1;

        while(tc-->0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            price = Integer.parseInt(st.nextToken());

            answer = 0;
            map = new int[n][n];

            for(int i = 0; i < n; i++) {
                st= new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int k = 1; k <= n+1; k++ ) {
                cost = k * k + ((k - 1) * (k - 1));
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        visited = new boolean[n][n];
                        bfs(i, j, k);
                    }
                }
            }

            sb.append(String.format("#%d %d\n", printIndex++, answer));

        }

        System.out.println(sb);
    }
}
