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
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n-->0) {
            String tmp[] = br.readLine().split(" ");
            int arr[] = new int[10];

            Arrays.setAll(arr, x -> (Integer.parseInt(tmp[x])));
            Arrays.sort(arr);
            sb.append(arr[7]+"\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}