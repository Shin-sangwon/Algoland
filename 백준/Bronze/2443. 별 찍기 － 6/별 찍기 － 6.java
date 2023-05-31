import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = n; i > 0; i--) {
            int tmp = 0;
            while(tmp != cnt) {
                sb.append(" ");
                tmp++;
            }
            for(int j = 0; j < 2 * i - 1 ; j++) {
                sb.append("*");
            }

            cnt++;
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
