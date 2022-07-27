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
        int n = Integer.parseInt(br.readLine());
        int ans = 1;
        int arr[] = new int[55];
        Arrays.fill(arr, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++){
            int tmp = 1;
            for(int j = i+1; j < i + 5; j++){
                if(arr[j] - arr[i] < 5 && arr[j] - arr[i] > 0) tmp++;
            }
            ans = Math.max(ans, tmp);
        }

        bw.write(ans >= 5 ? 0+"" : 5 - ans+"");
        bw.flush();
        bw.close();







    }
}
