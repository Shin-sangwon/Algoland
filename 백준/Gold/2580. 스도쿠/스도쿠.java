import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static boolean[][] rowVisit, columnVisit, squareVisit;
    static int[][] map;
    static StringBuilder sb;
    static boolean flag;

    private static void print() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
    }
    private static void dfs(int cnt) {

        if(cnt == 81) {
            if(flag) {
                return;
            }
            flag = true;
            print();
            return;
        }

        int x = cnt / 9;
        int y = cnt % 9;

        if(map[x][y] != 0) dfs(cnt + 1);
        if(map[x][y] == 0) {
            //1부터 9까지 넣어보기
            for(int i = 1; i <= 9 && !flag; i++) {
                if(rowVisit[x][i] || columnVisit[y][i] || squareVisit[3 * (x/3) + y/3][i]) continue;
                //넣어보기
                rowVisit[x][i] = true;
                columnVisit[y][i] = true;
                squareVisit[3 * (x/3) + y/3][i] = true;
                map[x][y] = i;
                dfs(cnt+1);
                //아니라면 돌아와서 뺴주기
                rowVisit[x][i] = false;
                columnVisit[y][i] = false;
                squareVisit[3 * (x/3) + y/3][i] = false;
                map[x][y] = 0;
            }
        }


    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        map = new int[9][9];
        rowVisit = new boolean[9][10];
        columnVisit = new boolean[9][10];
        squareVisit = new boolean[9][10];

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //사용했는지 체크하기
                rowVisit[i][map[i][j]] = true;
                columnVisit[j][map[i][j]] = true;
                squareVisit[3 * (i / 3) + j / 3][map[i][j]] = true;
            }
        }

        flag = false;

        dfs(0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}