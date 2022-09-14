import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    static int n,m;
    static int arr[];
    static boolean checker[];
    static StringBuilder sb;

    static void recursive(int x) {

        if(x == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!checker[i]) {
                arr[x] = i;
                checker[i] = true;
                recursive(x + 1);
                checker[i] = false;
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        sb = new StringBuilder();
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        arr = new int[10];
        checker = new boolean[10];
        recursive(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();




    }
}