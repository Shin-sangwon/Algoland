import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[3];

        for(int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int ans = (arr[2] - arr[0]) + (arr[2] - arr[1]);

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();






    }

}
