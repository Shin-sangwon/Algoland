import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static final int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    static final int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        char arr[][];
        int ans[][];

        while(true) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            arr = new char[n][m];
            ans = new int[n][m];

            //배열 입력
            for(int i = 0; i < n; i++) {
                String tmp = br.readLine();
                for(int j = 0; j < m; j++) {
                    arr[i][j] = tmp.charAt(j);
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == '*') {
                        for(int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                            if(arr[nx][ny] != '*') ans[nx][ny] += 1;
                        }
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == '*') {
                        sb.append('*');
                        continue;
                    }
                    sb.append(ans[i][j]);
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();




    }
}