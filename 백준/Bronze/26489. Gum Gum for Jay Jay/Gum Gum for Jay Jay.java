import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {


     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        int answer = 0;
        
        while((str = br.readLine()) != null) answer++;
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}