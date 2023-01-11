import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char arr[][] = new char[n][m];

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        TreeSet<String> set = new TreeSet<>();

        //가로
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(arr[i][j] == '#') {

                    if(sb.length() == 1 || sb.length() == 0) {
                        sb.setLength(0);
                        continue;
                    }
                    set.add(sb.toString());
                    sb.setLength(0);
                    continue;
                }

                sb.append(arr[i][j]);
                //마지막 문자
                if(j == m-1 && sb.length() > 1) {
                    set.add(sb.toString());
                    sb.setLength(0);
                    continue;
                }
                //마지막 문자인데
                if(j == m-1 && sb.length() <= 1) {
                    sb.setLength(0);
                }
            }
        }

        //세로
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[j][i] == '#') {

                    if(sb.length() == 1 || sb.length() == 0) {
                        sb.setLength(0);
                        continue;
                    }
                    set.add(sb.toString());
                    sb.setLength(0);
                    continue;
                }

                sb.append(arr[j][i]);

                if (j == n - 1 && sb.length() > 1) {
                    set.add(sb.toString());
                    sb.setLength(0);
                    continue;
                }

                if (j == n - 1 && sb.length() <= 1) {
                    sb.setLength(0);
                }
            }
        }

        bw.write(set.first().toString());
        bw.flush();
        bw.close();
        br.close();

    }
}