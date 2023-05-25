import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INDEX = 6;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        int x1 = x / 4;
        int y1 = y / 4;

        int x2 = x % 4;
        int y2 = y % 4;

        System.out.println(Math.abs(x1 - y1) + Math.abs(x2 - y2));


    }
}
