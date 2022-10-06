import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;


public class Main {

    static final int MAX_VALUE = (int) 1e9;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //노드, 간선
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int arr[][] = new int[n+1][n+1];

        //맥스값으로 채워넣기
        for(int a[] : arr) Arrays.fill(a, MAX_VALUE);

        //자기자신은 0
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++) {
                if(i == j) arr[i][j] = 0;
            }
        }
        //간선
        while(m-->0) {
            int inputs[] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            arr[inputs[0]][inputs[1]] = Math.min(arr[inputs[0]][inputs[1]], inputs[2]);
        }
        //플로이드 워셜
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){

                if(arr[i][j] == MAX_VALUE){
                    sb.append(0 + " ");
                    continue;
                }

                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}