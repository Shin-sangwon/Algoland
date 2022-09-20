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
        // 'A' -> 65
        int n = Integer.parseInt(br.readLine());

        while(n-->0) {
            boolean checker[] = new boolean[26];
            String tmp = br.readLine().toUpperCase();
            int count = 0;

            for(int i = 0; i < tmp.length(); i++) {
                if((tmp.charAt(i) >= 'A' && tmp.charAt(i) <= 'Z') && checker[tmp.charAt(i) - 65] == false) {
                    count++;
                    checker[tmp.charAt(i) - 65] = true;
                }
            }

            if(count == 26) {
                sb.append("pangram\n");
                continue;
            }

            StringBuilder tmpSb = new StringBuilder();

            for(int i = 0; i < checker.length; i++) {
                if(checker[i] == false) tmpSb.append(Character.toLowerCase((char)(i + 65)));
            }

            sb.append("missing ").append(tmpSb).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



   }
}