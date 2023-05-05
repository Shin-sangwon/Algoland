import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            HashSet<Integer> set = new HashSet<>();

            for(int i = 0; i < n; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            for(int i = 0; i < m; i++) {
                int now = Integer.parseInt(br.readLine());
                if(set.contains(now)) answer++;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);


    }
}