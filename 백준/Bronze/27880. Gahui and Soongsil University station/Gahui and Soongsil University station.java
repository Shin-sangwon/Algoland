import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int ES = 21;
    static final int ST = 17;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[2];

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            String tmp = st.nextToken();

            if(tmp.equals("Es")) {
                arr[0] += Integer.parseInt(st.nextToken());
            }else {
                arr[1] += Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(arr[0] * ES + arr[1] * ST);

    }
}
