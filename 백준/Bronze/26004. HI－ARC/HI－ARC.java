import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    static int arr[];
    public static void calc(Character ch) {
        if(ch == 'H') {
            arr[0]++;
        }

        if(ch == 'I') {
            arr[1]++;
        }

        if(ch == 'A') {
            arr[2]++;
        }

        if(ch == 'R') {
            arr[3]++;
        }

        if(ch == 'C') {
            arr[4]++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[5];

        int n = Integer.parseInt(br.readLine());

        br.readLine().chars()
                .forEach(x -> calc((char) x));

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < ans) {
                ans = arr[i];
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

}