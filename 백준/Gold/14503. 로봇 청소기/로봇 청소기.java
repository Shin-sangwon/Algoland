import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m, answer;
    static int[][] map;
    static boolean[][] visited;
    static Robot robot;

    static class Robot{
        int x;
        int y;
        int d;
        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", d=" + d +
                '}';
        }
    }

    private static boolean search() {

        for(int k = 0; k < 4; k++) {
            int nx = robot.x + dx[k];
            int ny = robot.y + dy[k];

            if(!isPossible(nx, ny)) continue;

            if(map[nx][ny] == 0) return true;
        }


        return false;
    }

    private static boolean isPossible(int nx, int ny) {

        return (nx >= 0 && ny >= 0 && nx < n && ny < m) && (map[nx][ny] != 1);
    }

    private static boolean isCleanable(int nx, int ny) {

        return (nx >= 0 && ny >= 0 && nx < n && ny < m) && (map[nx][ny] == 0);

    }

    private static boolean rotate() {

        robot.d -= 1;

        if(robot.d == -1) robot.d = 3;

        int nx = robot.x + dx[robot.d];
        int ny = robot.y + dy[robot.d];

        if(isCleanable(nx, ny)) {
            robot.x = nx;
            robot.y = ny;
            return false;
        }

        return true;

    }

    private static void clean() {

        answer = 0;
        while(true) {

            if(map[robot.x][robot.y] == 0) {
                answer += 1;
                map[robot.x][robot.y] = -1;
            }

            if(!search()) {

                int nx = robot.x + dx[(robot.d + 2) % 4];
                int ny = robot.y + dy[(robot.d + 2) % 4];
                if(isPossible(nx, ny)) {
                    robot.x = nx;
                    robot.y = ny;
                    continue;
                }

                return;
            }

            if(search()) {

                while(rotate());
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        st = new StringTokenizer(br.readLine());

        robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean();
        System.out.println(answer);
    }
}
