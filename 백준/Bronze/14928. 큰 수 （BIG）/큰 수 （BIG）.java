import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String bigNum = br.readLine();
        final int TARGET = 20000303;
        long ans = 0;

        for(int i = 0; i < bigNum.length(); i++){
            ans = (ans * 10 + (bigNum.charAt(i) - '0')) % TARGET;
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
