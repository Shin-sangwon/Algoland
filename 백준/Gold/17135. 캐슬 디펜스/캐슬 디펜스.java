import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int n, m, d, answer, map[][];
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int dis;
        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis == o.dis? this.y - o.y : this.dis - o.dis;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dis=" + dis +
                    '}';
        }
    }

    private static void findArchers(int cnt, int start, int[] archers) {

        if(cnt == 3) {
            int[][] copyMap = Arrays.stream(map)
                            .map(int[]::clone)
                            .toArray(int[][]::new);

            defense(archers, copyMap);
            return;
        }

        for(int i = start; i < m; i++) {

            archers[cnt] = i;
            findArchers(cnt + 1, i + 1, archers);
        }

    }

    private static void defense(int[] archers, int[][] copyMap) {

        int location = n;
        int tmp = 0;
        while(location != 0) {
            HashSet<Node> totalEnemies = new HashSet<>();
            for(int i = 0; i < 3; i++) {

                Queue<Node> queue = new LinkedList<>();
                boolean[][] visited = new boolean[n][m];
                queue.add(new Node(location, archers[i], 0));
                TreeSet<Node> enemies = new TreeSet<>();

                while(!queue.isEmpty()) {

                    Node node = queue.poll();
                    for(int k = 0; k < 3; k++) {
                        int nx = node.x + dx[k];
                        int ny = node.y + dy[k];

                        if(nx < 0 || ny < 0 || nx >= location || ny >= m) continue;
                        if(visited[nx][ny]) continue;
                        int nowDis = Math.abs(location - nx) + Math.abs(archers[i] - ny);
                        if(nowDis > d) continue;

                        queue.add(new Node(nx, ny, nowDis));
                        visited[nx][ny] = true;
                        if(copyMap[nx][ny] == 1) {
                            enemies.add(new Node(nx, ny, nowDis));
                        }
                    }
                }

                if(enemies.size() != 0) {
                    totalEnemies.add(enemies.first());
                }
            }

            if(totalEnemies.size() != 0) {
                tmp += totalEnemies.size();
                for(Node node : totalEnemies) {
                    copyMap[node.x][node.y] = 0;
                }
            }
            location--;
        }

        answer = Math.max(answer, tmp);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MIN_VALUE;
        int[] archers = new int[3];
        findArchers(0, 0, archers);

        System.out.println(answer);
    }
}
