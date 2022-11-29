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

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int ans = 0;
        while(n-->0) {
            st = new StringTokenizer(br.readLine(), "D-");

            int tmp = Integer.parseInt(st.nextToken());

            if(tmp <= 90) ans++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

}