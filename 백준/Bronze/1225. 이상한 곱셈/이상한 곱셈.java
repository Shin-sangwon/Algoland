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
        long ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        char arr1[] = st.nextToken().toCharArray();
        char arr2[] = st.nextToken().toCharArray();

        for(char x : arr1) {
            for(char y : arr2) {
                ans += Character.getNumericValue(x) * Character.getNumericValue(y);
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();

    }

}