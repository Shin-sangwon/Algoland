import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalPrice = Integer.parseInt(br.readLine());

        int n = 9;

        while(n-->0) {
            totalPrice -= Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(totalPrice));
        bw.flush();
        bw.close();
        br.close();
    }

}