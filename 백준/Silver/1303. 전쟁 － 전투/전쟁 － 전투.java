import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] arr;
    static boolean[][] visited;

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        int whiteTeam = 0;
        int blueTeam = 0;

        //input
        for(int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                arr[i][j] = tmp[j];
            }
        }
        //bfs settings
        visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j]) continue;

                char now = arr[i][j];
                queue.add(new Node(i, j));
                visited[i][j] = true;
                int colorCount = 1;

                while(!queue.isEmpty()) {
                    Node node = queue.poll();
                    for(int k = 0; k < 4; k++) {
                        int nx = node.x + dx[k];
                        int ny = node.y + dy[k];

                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                        if(arr[i][j] == arr[nx][ny] && !visited[nx][ny]) {
                            colorCount++;
                            queue.add(new Node(nx, ny));
                            visited[nx][ny] = true;
                        }

                    }
                }

                if (arr[i][j] == 'W') {
                    whiteTeam += Math.pow(colorCount, 2);
                    continue;
                }

                blueTeam += Math.pow(colorCount, 2);

            }
        }

        sb.append(whiteTeam + " " + blueTeam);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}