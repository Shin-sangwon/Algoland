import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());
        //A 65 a 97
        while(st.hasMoreTokens()) {
            String idx = st.nextToken();
            str = str.replaceAll(idx, idx.toLowerCase(Locale.ROOT));
        }

        bw.write(str);
        bw.flush();
        bw.close();
        br.close();
    }

}