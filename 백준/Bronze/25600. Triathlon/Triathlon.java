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
        int ans = Integer.MIN_VALUE;
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        while(n-->0) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            int tmp = (d+g) * a;


            ans = Math.max(ans, d+g==a?tmp*2:tmp);

        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();

    }

}