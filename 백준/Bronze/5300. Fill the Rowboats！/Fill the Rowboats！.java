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

        final String index = "Go!";
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            sb.append(i + " ");
            if(i % 6 == 0) {
                sb.append(index + " ");
            }

        }

        if(n % 6 != 0) {
            sb.append(index);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}