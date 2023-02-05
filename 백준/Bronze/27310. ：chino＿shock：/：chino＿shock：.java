import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {


     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int colon = 0;
        int underbar = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ':') colon++;
            if(str.charAt(i) == '_') underbar++;
        }

         bw.write(String.valueOf(str.length() + colon + 5 * underbar));
         bw.flush();
         bw.close();
         br.close();

    }
}