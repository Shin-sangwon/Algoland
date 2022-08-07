import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 0;
        for(int i = 0; i < 4; i++){
            ans += Integer.parseInt(br.readLine());
        }

        bw.write(ans / 60 + "\n" + ans % 60);
        bw.flush();
        bw.close();
        br.close();

    }
}
