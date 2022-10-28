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

        int now = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int answer = Math.abs(now-target);

        int n = Integer.parseInt(br.readLine());
        while(n-->0) {
            int tmp = Integer.parseInt(br.readLine());

            answer = Math.min(answer, Math.abs(tmp-target)+1);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

}