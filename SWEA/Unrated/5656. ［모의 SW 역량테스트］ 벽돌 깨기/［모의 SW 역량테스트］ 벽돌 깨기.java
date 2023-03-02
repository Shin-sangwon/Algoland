import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
    //상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, w, h, answer, numbers[], map[][], copyMap[][];
    static boolean[][] visited;

    static class Node{
        int x;
        int y;
        int num;
        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

    }

    private static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[h][w];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        return tmp;
    }

    private static int[][] fillBlank(int[][] map) {

        for(int i = 0; i < w; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for(int j = h - 1; j >= 0; j--) {
                if(copyMap[j][i] != 0) queue.add(copyMap[j][i]);
            }
            for(int k = h - 1; k >= 0; k--) {
                if(queue.isEmpty()) copyMap[k][i] = 0;
                else copyMap[k][i] = queue.poll();
            }

        }

        return map;
    }
    private static int findH(int w) {

        for(int i = 0; i < h; i++) {
            if(copyMap[i][w] != 0) return i;
        }

        return -1;
    }

    private static int findBlock() {
        int tmp = 0;
        for(int[] x : copyMap) {
            for(int y : x) {
                if(y != 0) tmp++;
            }
        }

        return tmp;
    }
    private static void bfs() {

        for(int i = 0; i < n; i++) {
            visited = new boolean[h][w];
            int startY = numbers[i];
            int startX = findH(numbers[i]);
            if(startX == -1) continue;

            Node start = new Node(startX, startY, copyMap[startX][startY]);
            Queue<Node> queue = new LinkedList<>();
            queue.add(start);
            copyMap[start.x][start.y] = 0;
            while(!queue.isEmpty()) {

                Node node = queue.poll();
                for(int k = 0; k < 4; k++) {
                    int nx = node.x;
                    int ny = node.y;
                    int num = node.num;
                    for(int j = 0; j < node.num - 1; j++) {
                        nx += dx[k];
                        ny += dy[k];
                        if(nx < 0 || ny < 0 || nx >= h || ny >= w) break;
                        if(copyMap[nx][ny] == 0) continue;
                        if(copyMap[nx][ny] > 1) queue.add(new Node(nx, ny, copyMap[nx][ny]));
                        copyMap[nx][ny] = 0;
                    }
                }
            }
            fillBlank(copyMap);
            }


    }
    private static void makeMarble(int cnt) {

        if(cnt == n) {
            copyMap = copyMap(map);
            bfs();
            answer = Math.min(answer, findBlock());
            return;
        }

        for(int i = 0; i < w; i++) {
            numbers[cnt] = i;
            makeMarble(cnt + 1);
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
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;
            map = new int[h][w];
            numbers = new int[n];

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            makeMarble(0);

            sb.append(String.format("#%d %d\n", printIndex++, answer));

        }

        System.out.println(sb);

    }
}
