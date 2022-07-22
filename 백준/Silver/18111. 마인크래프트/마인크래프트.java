import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    /*
    좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. 2초
    인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. 1초
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n, m, block;
        int arr[][];

        st = new StringTokenizer(br.readLine());
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        block = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] < minHeight) minHeight = arr[i][j];
                if(arr[i][j] > maxHeight) maxHeight = arr[i][j];
            }
        }

        int ansTime = Integer.MAX_VALUE;
        int ansHeight = 0;

        for(int k = minHeight; k <= maxHeight; k++){
            int tmpBlock = block;
            int tmpTime = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){

                    int tmpCalc = arr[i][j] - k;

                    if(tmpCalc > 0) {
                        tmpTime += Math.abs(tmpCalc) * 2;
                        tmpBlock += Math.abs(tmpCalc);
                    }

                    else if(tmpCalc < 0){
                        tmpTime += Math.abs(tmpCalc);
                        tmpBlock -= Math.abs(tmpCalc);
                    }
                }
            }

            if(tmpBlock < 0){
                continue;
            }

            if(ansTime >= tmpTime){
                ansTime = tmpTime;
                ansHeight = k;
            }
        }

        bw.write(ansTime + " " + ansHeight);
        bw.flush();
        bw.close();
        br.close();

    }
}