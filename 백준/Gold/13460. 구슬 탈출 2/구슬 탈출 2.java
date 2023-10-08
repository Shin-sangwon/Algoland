import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n,m;
    static char[][] map;
    static Node red;
    static Node blue;
    static Node target;
    static int answer = Integer.MAX_VALUE;
    static Node currentRed;
    static Node currentBlue;
    static boolean stopSearch = false;


    public static void main(String[] args) throws IOException{

        init();
        search(0);
        System.out.println(answer > 10? -1 : answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'R') {
                    red = new Node(i, j);
                    continue;
                }

                if(map[i][j] == 'B') {
                    blue = new Node(i, j);
                    continue;
                }

                if(map[i][j] == 'O') {
                    target = new Node(i, j);
                }
            }
        }
    }


    private static void search(int count) {
        if(count > 10 || stopSearch) {
            stopSearch = false;
            return;
        }

        for(int i = 0; i < 4; i++) {
            Node prevRed = new Node(red.x, red.y);
            Node prevBlue = new Node(blue.x, blue.y);

            move(i, count+1);

            search(count+1);

            red = prevRed;
            blue = prevBlue;
        }
    }
    // true : 빨간 구슬 or 아무 구슬 먼저,  false : 파란 구슬
    private static boolean findFirstOrder(int direction) {

        if(direction == 0) return currentRed.x <= currentBlue.x;
        if(direction == 1) return currentRed.x >= currentBlue.x;
        if(direction == 2) return currentRed.y <= currentBlue.y;
        return currentRed.y >= currentBlue.y;
    }


    private static void move(int direction, int count) {
        Node tmpRed = moveSingleBall(new Node(red.x, red.y), direction);
        Node tmpBlue = moveSingleBall(new Node(blue.x, blue.y), direction);

        if (map[tmpRed.x][tmpRed.y] == 'O' && map[tmpBlue.x][tmpBlue.y] == 'O') return;

        if (map[tmpBlue.x][tmpBlue.y] == 'O') {
            stopSearch = true;
            return;
        }

        if (tmpRed.x == tmpBlue.x && tmpRed.y == tmpBlue.y) {
            // 두 구슬이 같은 위치에 있을 경우, 원래의 위치와 비교하여 더 멀리서 온 구슬을 한 칸 뒤로 움직입니다.
            switch (direction) {
                case 0:
                    if (red.x > blue.x) tmpRed.x += 1;
                    else tmpBlue.x += 1;
                    break;
                case 1:
                    if (red.x > blue.x) tmpBlue.x -= 1;
                    else tmpRed.x -= 1;
                    break;
                case 2:
                    if (red.y > blue.y) tmpRed.y += 1;
                    else tmpBlue.y += 1;
                    break;
                case 3:
                    if (red.y > blue.y) tmpBlue.y -= 1;
                    else tmpRed.y -= 1;
                    break;
            }
        }

        red = tmpRed;
        blue = tmpBlue;

        if (map[blue.x][blue.y] == 'O') return;
        if (map[red.x][red.y] == 'O') {
            answer = Math.min(answer, count);
        }
    }

    private static Node moveSingleBall(Node ball, int direction) {
        while (true) {
            int nx = ball.x + dx[direction];
            int ny = ball.y + dy[direction];

            if (map[nx][ny] == '#') break;
            if (map[nx][ny] == 'O') {
                ball.x = nx;
                ball.y = ny;
                break;
            }

            ball.x = nx;
            ball.y = ny;
        }
        return ball;
    }

}
