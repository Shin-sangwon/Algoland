import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 10;
    static int answer;
    static int[] paper;
    static int[][] map;


    private static boolean isPossible(int x, int y, int size) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {    
                if (map[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

    private static boolean isOnBoundary(int x, int y, int size) {

        return x >= 0 && y >= 0 && x + size <= 10 && y + size <= 10;
    }

    private static void spread(int x, int y, int size, int index) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = index;
            }
        }

    }

    private static void dfs(int x, int y, int cnt) {
       
        if (x >= 9 && y > 9) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (y > 9) {
            dfs(x + 1, 0, cnt);
            return;
        }

        
        if (map[x][y] == 1) {

            for (int i = 5; i >= 1; i--) {

                if (paper[i] > 0 && isOnBoundary(x, y, i) && isPossible(x, y, i)) {

                    paper[i]--;
                    spread(x, y, i, 0);
                    dfs(x, y + 1, cnt + 1);
                    spread(x, y, i, 1);
                    paper[i]++;

                }

            }

        } else {
            dfs(x, y + 1, cnt);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[SIZE][SIZE];
        paper = new int[] {0, 5, 5, 5, 5, 5};
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
  
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);


    }

}
