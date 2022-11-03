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

        int a = 0;
        int b = 1;

        while(true) {
            n--;

            if(n == 0) {
                break;
            }

            int tmp = a;
            a = b;
            b += tmp;
        }

        sb.append(a + " " + b);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}