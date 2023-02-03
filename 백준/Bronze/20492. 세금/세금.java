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

        double n = Double.parseDouble(br.readLine());

        sb.append((int) (n * 0.78));
        sb.append(" ");
        sb.append( (int) ((n * 0.2)* 0.78) + (int) (n * 0.8));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}