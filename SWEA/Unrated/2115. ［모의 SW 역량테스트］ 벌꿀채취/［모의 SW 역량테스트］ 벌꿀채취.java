import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int n, m, c, arr[][], honey[];

    private static void collect(int now, int j, int end, int cnt, int rowSum, int honeySum) {

        honey[now] = Math.max(honey[now], honeySum);

        if(cnt == m) {
            return;
        }

        for(int i = j + 1; i < end; i++) {
            if(rowSum + arr[now][i] <= c) {
                collect(now, i, end,cnt + 1, rowSum + arr[now][i], honeySum + (int) (Math.pow(arr[now][i], 2)));
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int printIndex = 1;

        while(tc-->0) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            honey = new int[n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j <= n - m; j++) {
                    collect(i, j - 1,j + m,0, 0, 0);

                }
            }

            int answer = 0;
            Arrays.sort(honey);
            answer += honey[n-1];
            answer += honey[n-2];

            sb.append(String.format("#%d %d\n", printIndex++, answer));

        }
        System.out.println(sb);
    }
}
