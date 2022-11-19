import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Solution {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int totalCase = 10;
        while(totalCase -- > 0) {
            int n = Integer.parseInt(br.readLine());
            String regex = br.readLine();

            String tmp = br.readLine().replaceAll(regex, "-1");

            int ans = 0;

            for(int i = 0; i < tmp.length()-1; i++) {
                if(tmp.substring(i, i+2).equals("-1")) ans++;
            }
            sb.append(String.format("#%d %d\n", n, ans));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}