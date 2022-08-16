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

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        while(true) {

            if(n == 1) {
                sb.append("Before");
                break;
            }

            if(n == 2) {
                if(m < 18) {
                    sb.append("Before");
                    break;
                }

                if(m == 18) {
                    sb.append("Special");
                    break;
                }

                sb.append("After");
                break;
            }

            sb.append("After");
            break;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
