import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

     static boolean isPelin(String str) {

         for(int i = 0; i < str.length()/2; i++) {
             if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
         }

         return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-->0) {
            String tmp = br.readLine();

            sb.append(isPelin(tmp.toLowerCase())? "Yes\n" : "No\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();





   }
}