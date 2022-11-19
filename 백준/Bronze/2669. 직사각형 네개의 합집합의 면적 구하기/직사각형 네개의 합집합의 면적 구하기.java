import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        boolean arr[][] = new boolean[101][101];

        int n = 4;
        int ans = 0;
        while(n-->0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = x1; i < x2; i++) {
                for(int j = y1; j < y2; j++) {
                    arr[i][j] = true;
                }
            }
        }

        for(boolean x[] : arr) {
            for(boolean y : x) {
                if(y) ans++;
            }
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();

    }

}