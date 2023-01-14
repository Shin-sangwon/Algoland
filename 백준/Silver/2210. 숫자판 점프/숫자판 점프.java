import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static HashSet<Integer> set;


    private static void dfs(int i, int j, int depth, String str) {
        if(depth == 5) {
            set.add(Integer.parseInt(str));
            return;
        }

        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

            dfs(nx, ny, depth+1, str + arr[nx][ny]);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        arr = new int[5][5];
        set = new HashSet<>();

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(i, j, 0, String.valueOf(arr[i][j]));
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
        br.close();




    }
}