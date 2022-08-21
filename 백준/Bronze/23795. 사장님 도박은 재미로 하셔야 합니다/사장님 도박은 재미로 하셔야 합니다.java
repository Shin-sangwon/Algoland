import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long ans = 0;

        while(true) {
            long tmp = Long.parseLong(br.readLine());

            if(tmp == -1) break;

            ans += tmp;

        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

}
