import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;


public class Main {

    static StringBuilder sb;
    static void hanoi(int a, int b, int n) {

        if(n == 1) {
            sb.append(a + " " + b).append("\n");
            return;
        }

        hanoi(a, 6-a-b, n-1);
        sb.append(a + " " + b).append("\n");
        hanoi(6-a-b, b, n-1);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        BigInteger bl = new BigInteger("2").pow(n).subtract(new BigInteger("1"));
        sb.append(bl).append("\n");
        

        if(n > 20) {
            bw.write(bl.toString());
        } else {
            hanoi(1, 3, n);
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
        

    }
}