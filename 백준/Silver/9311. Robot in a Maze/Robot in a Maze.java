import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

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
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    final static String INDEX = "Shortest Path: ";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Loop1:
        while(tc-->0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[n][m];
            visited = new boolean[n][m];
            Queue<Node> queue = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 'S') {
                        queue.add(new Node(i, j, 0));
                        visited[i][j] = true;
                    }
                }
            }

            while(!queue.isEmpty()) {
                Node node = queue.poll();

                if(map[node.x][node.y] == 'G') {
                    sb.append(INDEX).append(node.length).append("\n");
                    continue Loop1;
                }

                for(int k = 0; k < 4; k++) {
                    int nx = node.x + dx[k];
                    int ny = node.y + dy[k];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if(visited[nx][ny]) continue;
                    if(map[nx][ny] =='X') continue;

                    queue.add(new Node(nx, ny, node.length+1));
                    visited[nx][ny] = true;
                }
            }

            sb.append("No Exit\n");

        }

        System.out.println(sb);

    }
}