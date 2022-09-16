import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());

       int arr[] = Stream.of(br.readLine().split(" "))
               .mapToInt(Integer::parseInt)
               .toArray();

       // 투 포인터

        int endIdx = 0;
        int sum = 0;
        int answer = 0;

        for(int startIdx = 0; startIdx < n; startIdx++) {
            while(endIdx < n && sum < m) {
                sum += arr[endIdx];
                endIdx++;
            }

            if(endIdx == n+1) break;

            if(sum == m) answer++;

            sum -= arr[startIdx];

        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();


   }
}