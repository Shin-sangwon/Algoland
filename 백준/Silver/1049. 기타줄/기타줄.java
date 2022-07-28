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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr1[] = new int[m];
        int arr2[] = new int[m];

        int ans = 0;


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1); Arrays.sort(arr2);
        int tmp = n * arr2[0];
        while(true){
            while(n >= 6){
                n -= 6;
                ans += arr1[0];
            }

            if(n == 0) break;

            ans = Math.min(ans + arr1[0], ans + arr2[0] * n);

            break;

        }

        ans = Math.min(ans, tmp);
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();


    }
}
