import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            int leaf = 1;

            for(int i = 0; i < n * 2; i++) {
                int tmp = Integer.parseInt(st.nextToken());

                if(i % 2 == 0) {
                    leaf *= tmp;
                    continue;
                }

                leaf -= tmp;
            }

            sb.append(leaf).append("\n");

        }

        System.out.println(sb);

    }
}
