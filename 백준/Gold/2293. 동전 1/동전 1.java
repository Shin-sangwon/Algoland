import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] coins = new int[n];
        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            for(int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        bw.write(String.valueOf(dp[k]));
        bw.flush();
        bw.close();
        br.close();

    }
}