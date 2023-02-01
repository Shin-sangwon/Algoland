import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    private static int calc(int n, int m) {

        if(m == 1) {
            return 280;
        }

        if( (n >= 12 && n <= 16)) {
            return 320;
        }

        return 280;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = calc(n, m);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}