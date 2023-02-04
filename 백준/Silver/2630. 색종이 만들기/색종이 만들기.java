import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    static int[][] map;
    static int white = 0;
    static int blue = 0;

    public static boolean checker(int x, int y, int length) {
        int index = map[x][y];

        for(int i = x; i < x + length; i++) {
            for(int j = y; j < y + length; j++) {
                if(index != map[i][j]) return false;
            }
        }

        return true;
    }

    private static void divide(int x, int y, int length) {
        if(checker(x, y, length) || length == 1) {
            if(map[x][y] == 0) {
                white++;
                return;
            }
            blue++;
            return;
        }

        divide(x, y, length/2);
        divide(x, y+length/2, length/2);
        divide(x + length/2, y, length/2);
        divide(x + length/2, y + length/2 , length/2);

    }

     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        divide(0, 0, n);

        StringBuilder sb = new StringBuilder().append(white).append("\n").append(blue);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}