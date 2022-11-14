import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    static boolean isPalin(String num) {

        for(int i = 0; i < num.length()/2; i++) {
            if(num.charAt(i) != num.charAt(num.length()-1-i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n-->0) {
            sb.setLength(0);
            int num = Integer.parseInt(br.readLine());
            sb.append(num);
            int reverse = Integer.parseInt(sb.reverse().toString());

            boolean checker = isPalin(String.valueOf(num+reverse));
            ans.append(checker? "YES" : "NO").append("\n");
        }

        bw.write(ans.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}