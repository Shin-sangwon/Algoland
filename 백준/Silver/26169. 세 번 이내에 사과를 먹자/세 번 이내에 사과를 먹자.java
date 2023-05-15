import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, 1, 0, -1};
    static int map[][];
    static int answer;

    private static int[][] copy(int[][] map) {
        int[][] tmpMap = new int[5][5];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }
        return tmpMap;
    }
    private static void dfs(int x, int y, int[][] map, int depth, int apple) {

        if(depth == 4) {
            return;
        }

        if(apple == 2) {
            answer = 1;
            return;
        }

        for(int k = 0 ; k < 4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

            if(map[nx][ny] == -1) continue;

            int[][] tmpMap = copy(map);
            tmpMap[x][y] = -1;

            if(map[nx][ny] == 0) {
                dfs(nx, ny, tmpMap, depth + 1, apple);
            }else {
                dfs(nx, ny, tmpMap, depth + 1, apple + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][5];

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        answer = 0;

        dfs(r, c, copy(map), 0, 0);

        System.out.println(answer);
    }
}