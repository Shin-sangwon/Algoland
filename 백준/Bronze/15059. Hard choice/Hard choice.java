import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] index = new int[3];
        int[] selected = new int[3];

        for(int i = 0; i < 3; i++) {
            index[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            selected[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 0; i < 3; i++) {
            if(selected[i] - index[i] > 0) answer += selected[i] - index[i];
        }

        System.out.println(answer);
    }
}
