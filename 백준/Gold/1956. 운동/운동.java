import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static final int MAX_VALUE = (int) 1e9;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n+1][n+1];
        //max값으로 세팅
        for(int[] tmp : arr) {
            Arrays.fill(tmp, MAX_VALUE);
        }

        while(m-->0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[start][end] = cost;

        }

        //자기 자신은 0
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < n+1; j++) {
                if(i == j) arr[i][j] = 0;
            }
        }

        //플로이드-워셜
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int ans = MAX_VALUE;

        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <= n; j++) {
                ans = Math.min(ans, arr[i][j] + arr[j][i]);
            }
        }


        bw.write(ans == MAX_VALUE? "-1" : ans+"");
        bw.flush();
        bw.close();
        br.close();




    }
}