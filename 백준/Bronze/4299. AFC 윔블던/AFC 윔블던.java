import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        int arr[] = new int[2];

        arr[0] = (sum + sub) / 2;
        arr[1] = sum - arr[0];

        if((sum + sub) % 2 != 0) {
            System.out.println(-1);
            return;
        }

        if(sum < sub) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(arr);

        System.out.println(arr[1] + " " + arr[0]);

    }
}