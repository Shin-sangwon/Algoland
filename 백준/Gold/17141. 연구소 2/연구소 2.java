import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, 1, 0, -1};
    static int n, m, virusCount, answer;
    static ArrayList<Node> virusList;
    static int[][] map, virusMap, copyMap;
    static int[] numbers;

    static class Node {

        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static int getMaxNumber() {

        return Arrays.stream(copyMap)
                     .flatMapToInt(Arrays::stream)
                     .max()
                     .getAsInt();
    }

    private static boolean isPossible() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyMap[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[][] copy() {
        copyMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[i][j] = virusMap[i][j];
            }
        }

        return copyMap;
    }

    private static void bfs() {

        boolean[][] visited = new boolean[n][n];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Node virus = virusList.get(numbers[i]);
            visited[virus.x][virus.y] = true;
            copyMap[virus.x][virus.y] = 1;
            queue.add(virus);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + node.x;
                int ny = dy[k] + node.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    continue;
                }
                copyMap[nx][ny] = node.cnt + 1;
                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, node.cnt + 1));
            }
        }

    }

    private static void spread(int cnt, int start) {

        if (cnt == m) {
            copy();
            bfs();

            if (isPossible()) {
                answer = Math.min(answer, getMaxNumber());
            }

            return;
        }

        for (int i = start; i < virusCount; i++) {

            numbers[cnt] = i;
            spread(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        virusMap = new int[n][n];
        numbers = new int[m];
        virusList = new ArrayList<>();
        virusCount = 0;
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 2) {
                    virusMap[i][j] = map[i][j];
                }
                if (map[i][j] == 2) {
                    virusCount++;
                    virusList.add(new Node(i, j, 1));
                }
            }
        }
        spread(0, 0);

        System.out.println(answer == Integer.MAX_VALUE? -1 : answer - 1);

    }
}