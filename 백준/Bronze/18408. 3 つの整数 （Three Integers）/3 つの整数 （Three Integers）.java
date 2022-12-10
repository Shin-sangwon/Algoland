import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = 0;
        int two = 0;
        
        while(st.hasMoreTokens()) {
            
            int tmp = Integer.parseInt(st.nextToken());
            
            if(tmp == 1) {
                one++;
                continue;
            }
            
            if(tmp == 2) {
                two++;
            }
            
        }
        
        bw.write(one > two? "1" : "2");
        bw.flush();
        bw.close();
        br.close();

    }

}