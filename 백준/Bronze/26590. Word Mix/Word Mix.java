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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String firstStr = st.nextToken();
        String secondStr = st.nextToken();

        int n = Math.min(firstStr.length(), secondStr.length());

        for(int i = 0; i < n; i++) {

            if(i % 2 == 0) {
                sb.append(firstStr.charAt(i));
                continue;
            }

            sb.append(secondStr.charAt(i));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

}