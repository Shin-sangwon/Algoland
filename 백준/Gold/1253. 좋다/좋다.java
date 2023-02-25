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

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        Loop1:
        for(int i = 0; i < n; i++) {
            int target = arr[i];
            int startIdx = 0;
            int endIdx = n-1;


            while(startIdx <= endIdx) {

                if(startIdx == i) {
                    startIdx++;
                    continue;
                }

                if(endIdx == i) {
                    endIdx--;
                    continue;
                }

                if(startIdx == endIdx) break;

                int now = arr[startIdx] + arr[endIdx];
                if(now == target) {
                    answer++;
                    continue Loop1;
                }

                if(now > target) {
                    endIdx--;
                }else {
                    startIdx++;
                }
            }
        }

        System.out.println(answer);
    }
}