import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][];
        int[][] dp = new int[n][];

        for(int i = 1; i <= n; i++) {
            arr[i-1] = new int[i];
            dp[i-1] = new int[i];
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i+1; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                    continue;
                }
                if(j == i){
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int answer = Arrays.stream(dp[n-1])
            .max()
            .getAsInt();

        System.out.println(answer + arr[0][0]);

    }

}
