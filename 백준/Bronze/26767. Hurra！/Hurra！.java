import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // 7 -> Hurra! 11 -> Super! 7 || 11 -> Wiwat!
        int n = Integer.parseInt(br.readLine());

        final String HURRA = "Hurra!";
        final String SUPER = "Super!";
        final String WIWAT = "Wiwat!";

        for(int i = 1; i <= n; i++) {

            if(i % 7 == 0 && i % 11 != 0) {
                sb.append(HURRA).append("\n");
                continue;
            }

            if(i % 7 != 0 && i % 11 == 0) {
                sb.append(SUPER).append("\n");
                continue;
            }

            if(i % 7 == 0 && i % 11 == 0) {
                sb.append(WIWAT).append("\n");
                continue;
            }

            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}