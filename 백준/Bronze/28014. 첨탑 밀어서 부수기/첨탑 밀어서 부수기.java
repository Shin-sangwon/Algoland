import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] tower = new int[n];

        int answer = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }

        int index = -1;


        while(index < n-1) {

            answer++;
            index++;

            while(index < n-1 && tower[index] > tower[index + 1]) {
                index++;
            }


        }

        System.out.println(answer);

    }
}
