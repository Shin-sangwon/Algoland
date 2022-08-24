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
        StringTokenizer st;

        int target = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int tmp = 0;

        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            tmp += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        bw.write(tmp == target? "Yes" : "No");
        bw.flush();
        bw.close();
        br.close(); 


    }

}
