import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 투 포인터 세팅
        Long ans = Long.MAX_VALUE;
        int startIdx;
        int endIdx = 0;

        for(startIdx = 0; startIdx < n; startIdx++) {
            while(endIdx < n && arr[endIdx] - arr[startIdx] < m) {
                endIdx++;
            }

            if(endIdx == n) break;

            ans = Math.min(ans, arr[endIdx] - arr[startIdx]);

        }


        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();


    }
}