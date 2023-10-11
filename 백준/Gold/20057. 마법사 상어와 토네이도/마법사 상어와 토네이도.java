import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    // 좌 하 우 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // 0이 되면 스피드가 1 증가
    static int count = 2;
    static int direction = 0;
    static int speed = 1;
    static Node node;
    static int answer = 0;
    static double[][][] tornado = {
        {{0, 0, 0.02, 0, 0},
            {0, 0.1, 0.07, 0.01, 0},
            {0.05, -1, 0, 0, 0},
            {0, 0.1, 0.07, 0.01, 0},
            {0, 0, 0.02, 0, 0}},
        {{0, 0, 0, 0, 0},
            {0, 0.01, 0, 0.01, 0},
            {0.02, 0.07, 0, 0.07, 0.02},
            {0, 0.1, -1, 0.1, 0},
            {0, 0, 0.05, 0, 0}},
        {{0, 0, 0.02, 0, 0},
            {0, 0.01, 0.07, 0.1, 0},
            {0, 0, 0, -1, 0.05},
            {0, 0.01, 0.07, 0.1, 0},
            {0, 0, 0.02, 0, 0}},
        {{0, 0, 0.05, 0, 0},
            {0, 0.1, -1, 0.1, 0},
            {0.02, 0.07, 0, 0.07, 0.02},
            {0, 0.01, 0, 0.01, 0},
            {0, 0, 0, 0, 0}}
    };


    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        move();
        System.out.print(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        node = new Node(n / 2, n / 2);

    }

    private static void move() {
        Loop1:
        while (true) {

            count--;
            for(int i = 0; i < speed; i++) {
                node.x += dx[direction];
                node.y += dy[direction];
                if (node.x < 0 || node.y < 0) {
                    break Loop1;
                }

                //if(map[node.x][node.y] != 0){
                    spread();
                //}

                if(i == speed - 1) {
                    direction += 1;
                    direction %= 4;
                }


            }

            if(count == 0) {
                count = 2;
                speed += 1;
            }

        }
    }

    private static void spread() {
        int totalSand = map[node.x][node.y];
        int spreadSand = 0;
        int nextX = 0;
        int nextY = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tornado[direction][i][j] != 0) {
                    int spreadAmount = (int) (totalSand * tornado[direction][i][j]);
                    if (tornado[direction][i][j] == -1) {
                        nextX = i;
                        nextY = j;
                        continue;
                    } else {
                        spreadSand += spreadAmount;
                    }

                    int nx = node.x + i - 2;
                    int ny = node.y + j - 2;

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        answer += spreadAmount;
                    } else {
                        map[nx][ny] += spreadAmount;
                    }
                }
            }
        }

        map[node.x][node.y] = 0;
        int restX = node.x + nextX - 2;
        int restY = node.y + nextY - 2;

        if (restX < 0 || restY < 0 || restY >= n || restX >= n) {
            answer += totalSand - spreadSand;
        } else {
            map[restX][restY] += totalSand - spreadSand;
        }
    }

}