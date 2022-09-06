import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger b1 = new BigInteger(st.nextToken());
        BigInteger b2 = new BigInteger(st.nextToken());


        BigInteger plus = b1.add(b2);
        BigInteger minus = b1.subtract(b2);

        bw.write(plus.multiply(minus).toString());
        bw.flush();
        bw.close();
        br.close();

    }
}