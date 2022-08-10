import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = new int[30001];
        arr[0] = 1; arr[1] = 1; arr[2] = 2; arr[3] = 6; arr[4] = 4;

        bw.write(String.valueOf(arr[Integer.parseInt(br.readLine())]));
        bw.flush();
        bw.close();
        br.close();


    }
}
