import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n,m,answer;
    static String[] arr;
    static boolean[] pick;

    private static void backtracking(int start, int cnt) {

        if(m - 5 < 0) {
            answer = 0;
            return;
        }

        if(m == 26) {
            answer = n;
            return;
        }

        if(cnt == m - 5) {
            int now = 0;
            Loop1:
            for(int i = 0; i < n; i++) {

                for(int j = 0; j < arr[i].length(); j++) {
                    char tmp = arr[i].charAt(j);
                    if(!pick[tmp - 97]) {
                        continue Loop1;
                    }
                }
                now++;
            }
            answer = Math.max(answer, now);
            return;
        }

        for(int i = start; i < 26; i++) {
            if(!pick[i]) {
                pick[i] = true;
                backtracking(i + 1, cnt + 1);
                pick[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MIN_VALUE;
        arr = new String[n];
        pick = new boolean[26];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            arr[i] = str.substring(4, str.length() - 4);
        }
        pick['a' - 97] = true;
        pick['n' - 97] = true;
        pick['t' - 97] = true;
        pick['i' - 97] = true;
        pick['c' - 97] = true;
        backtracking(0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();



    }
}
