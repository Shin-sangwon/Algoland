import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static boolean[] visited;
    static char[][] map;
    static int answer, n, m;
    static class Node{
        int x;
        int y;
        int dis;
        public Node(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    private static void dfs(int x, int y, int size) {

        visited[map[x][y] - 65] = true;

        for(int k = 0; k < 4; k++) {

            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if(!visited[map[nx][ny] - 65]) {
                answer = Math.max(answer, size + 1);
                dfs(nx, ny, size + 1);
            }
        }

        size--; visited[map[x][y] - 65] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[26];

        for(int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = tmp[j];
            }
        }

        answer = 1;

        dfs(0, 0, 1);

        System.out.println(answer);
    }
}
