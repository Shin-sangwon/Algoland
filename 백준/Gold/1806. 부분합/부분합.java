import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int endIdx = 0;
        int sum = arr[0];
        int length = 0x7fffffff;


        for(int startIdx = 0; startIdx < n; startIdx++) {
            while(endIdx < n && sum < m) {
                   endIdx++;
                   if(endIdx == n) {
                       continue;
                   }
                   sum += arr[endIdx];
            }

            if(endIdx == n) break;

            length = Math.min(length , endIdx - startIdx + 1);

            sum -= arr[startIdx];

        }

        bw.write(length == 0x7fffffff? "0" : length+"");
        bw.flush();
        bw.close();
        br.close();


    }
}