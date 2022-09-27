import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr1[] = new int[4];

        int arr2[] = new int[2];

        for(int i = 0; i < 4; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < 2; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int answer = 0;

        for(int i = 1; i <= 3; i++) {
            answer += arr1[i];
        }

        answer += arr2[1];

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}