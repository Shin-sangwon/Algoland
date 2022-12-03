import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static String calc(long a, long b, long c, long d) {

        long team1 = a * b;
        long team2 = c * d;

        return team1 == team2? "Tie" : team1 > team2? "TelecomParisTech" : "Eurecom";

    }

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
            Long c = Long.parseLong(st.nextToken());
            Long d = Long.parseLong(st.nextToken());

            sb.append(calc(a,b,c,d)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}