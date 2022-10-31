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
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int ans1 = 0;
        int ans2 = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            ans1 += tmp;
            arr[i] = tmp;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == 0) {
                ans2 += arr[i];
            }
        }

        sb.append(ans1 + "\n" + ans2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}