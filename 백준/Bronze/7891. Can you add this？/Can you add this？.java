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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        while(n-->0) {
            st = new StringTokenizer(br.readLine());

            Long a = Long.parseLong(st.nextToken());
            Long b = Long.parseLong(st.nextToken());
            sb.append(a + b).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();





    }
}