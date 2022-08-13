import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    static ArrayList<Integer> al;

    static void addPixel(int[][] arr, int first, int second) {

        ArrayList<Integer> tmpAl = new ArrayList<>();

        for(int i = first; i < first+3; i++){
            for(int j = second; j < second+3; j++){
                tmpAl.add(arr[i][j]);
            }
        }

        Collections.sort(tmpAl);

        al.add(tmpAl.get(4));

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int arr[][] = new int[r][c];

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < c; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = Integer.parseInt(br.readLine());
        al = new ArrayList<>();

        for(int i = 0; i < r-2; i++){
            for(int j = 0; j < c-2; j++){
                addPixel(arr, i, j);
            }
        }

        int ans = 0;

        for(int x : al) {
            if(x >= t) ans++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

}
