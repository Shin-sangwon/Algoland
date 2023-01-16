import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder().append("I");

        final String flag = "OI";

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 0; i < n; i++){
            sb.append(flag);
        }

        String in = br.readLine();

        for(int i = 0; i < m; i++){
            if(sb.length() > m-i) break;
            if(sb.length() > m) break;

            if(sb.toString().equals(in.substring(i, sb.length() + i))){
                ans++;
                i++;
            }
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
