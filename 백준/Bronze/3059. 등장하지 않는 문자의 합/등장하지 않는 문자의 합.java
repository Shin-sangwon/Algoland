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

        while(n-->0) {
            int ans = 0;
            boolean tmp[] = new boolean[26];

            String str = br.readLine();

            for(int i = 0; i < str.length(); i++) {
                tmp[str.charAt(i) - 65] = true;
            }

            for(int i = 0; i < tmp.length; i++) {
                if(tmp[i] == true) continue;

                ans += i + 65;
            }

            sb.append(ans+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }
}