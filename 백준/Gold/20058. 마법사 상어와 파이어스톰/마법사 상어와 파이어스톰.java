import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

    static int n,q, size;
    static int[][] map;
    static int[] queries;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static final int IDX = 2;
    static int restIceberg = 0;
    static boolean[][] visited;

    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        for(int x : queries) {
            fireStorm(x);
            melting();
        }
        search();

        StringBuilder sb = new StringBuilder();
        sb.append(findIce()).append("\n").append(restIceberg);

        System.out.println(sb);
    }

    private static void search() {

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }

    }

    private static void bfs(int startX, int startY) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        int count = 1;
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue;

                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny));
                count += 1;
            }
        }

        restIceberg = Math.max(restIceberg, count);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(IDX, n);

        map = new int[size][size];
        visited = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        queries = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void fireStorm(int query) {

        final int SQUARE_SIZE = (int) Math.pow(IDX, query);
        findSquare(SQUARE_SIZE);


    }

    private static void findSquare(final int SQUARE_SIZE) {

        for(int i = 0; i < size; i+= SQUARE_SIZE) {
            for(int j = 0; j < size; j+= SQUARE_SIZE) {
                rotate(i, j, SQUARE_SIZE);
            }
        }
    }

    private static void rotate(int x, int y, final int SQUARE_SIZE) {

        // 임시 배열
        int[][] temp = new int[SQUARE_SIZE][SQUARE_SIZE];

        // 90도 회전
        for(int i = 0; i < SQUARE_SIZE; i++) {
            for(int j = 0; j < SQUARE_SIZE; j++) {
                temp[j][SQUARE_SIZE - 1 - i] = map[x + i][y + j];
            }
        }

        // 원본에 반영
        for(int i = 0; i < SQUARE_SIZE; i++) {
            for(int j = 0; j < SQUARE_SIZE; j++) {
                map[x + i][y + j] = temp[i][j];
            }
        }
    }

    private static void melting() {

        int[][] copyMap = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] == 0) continue;
                int count = 0;
                Node node = new Node(i, j);

                for(int k = 0; k < 4; k++) {
                    int nx = dx[k] + node.x;
                    int ny = dy[k] + node.y;

                    if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue;

                    if(map[nx][ny] != 0) count++;
                }

                if(count < 3) {
                    copyMap[i][j] = map[i][j] - 1;
                }else {
                    copyMap[i][j] = map[i][j];
                }
            }

        }

        map = copyMap;

    }

    private static int findIce() {

        int answer = 0;
        for(int[] x : map) {
            for(int y : x) {
                answer += y;
            }
        }

        return answer;
    }

}
