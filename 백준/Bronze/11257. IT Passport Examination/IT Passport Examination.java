import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static boolean calc(int s, int m, int t) {

        if(s < 10.5 || m < 7.5 || t < 12) {
            return false;
        }

        if(s + m + t < 55) {
            return false;
        }

        return true;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(n-->0) {
            st = new StringTokenizer(br.readLine());

            sb.append(st.nextToken()).append(" ");

            int s = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            boolean checker = calc(s, m, t);

            sb.append(s+m+t).append(" ").append(checker? "PASS" : "FAIL").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}