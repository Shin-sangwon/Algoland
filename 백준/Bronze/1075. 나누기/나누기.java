import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    static int change(String x) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < x.length(); i++) {

            if(i > x.length() - 3) {
                sb.append("0");
            }else {
                sb.append(x.charAt(i));
            }

        }

        return Integer.parseInt(sb.toString());

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = change(br.readLine());
        int f = Integer.parseInt(br.readLine());


        int ans = 0;

        while(true) {

            if(n % f == 0) {
                break;
            }

            n++;
            ans++;

        }

        bw.write(ans < 10? "0" + ans: ans+"");
        bw.flush();
        bw.close();
        br.close();



    }
}