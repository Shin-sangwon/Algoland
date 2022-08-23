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
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 7; i++) {
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp % 2 != 0) {
                    continue;
                }

                sum += tmp;
                if(min > tmp) min = tmp;
            }

            sb.append("%d %d\n".formatted(sum, min));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

}
