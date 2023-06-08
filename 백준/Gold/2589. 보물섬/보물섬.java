import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, answer;
    static char[][] map;
    static boolean[][] visited;

    static class Node {

        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static void search(int x, int y) {

        visited = new boolean[n][m];
        visited[x][y] = true;
        Node start = new Node(x, y, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {

            Node node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (map[nx][ny] == 'W')
                    continue;

                queue.add(new Node(nx, ny, node.count + 1));
                visited[nx][ny] = true;
                answer = Math.max(answer, node.count + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = -1;
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine()
                       .toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    search(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
