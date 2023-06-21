import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());
            int apple = Integer.parseInt(st.nextToken());

            int tmp = apple / student;
            answer += apple - (student * tmp);
        }

        System.out.println(answer);

    }
}
