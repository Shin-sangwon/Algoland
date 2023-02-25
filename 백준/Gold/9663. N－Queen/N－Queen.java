import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  좌측 상단과 우측 하단 --> x-y가 같은지 여부
  우측 상단과 좌측 하단 --> x+y가 같은지 여부
  행, 열에 같이 있을 수 없음 --> x, y좌표가 같으면 안됨
 */

public class Main {

    static int answer;
    static boolean[] row, column, left, right;
    private static void recursive(int n, int target) {

        if(n == target) {
            answer++;
            return;
        }

        for (int i = 0; i < target; i++) {
            if (!row[i] && !column[i] && !left[n + i] && !right[target - 1 + i - n]) {
                row[i] = true;
                column[i] = true;
                left[n + i] = true;
                right[target - 1 + i - n] = true;

                recursive(n + 1, target);

                row[i] = false;
                column[i] = false;
                left[n + i] = false;
                right[target - 1 + i - n] = false;
            }
        }
    }

     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        answer = 0;
        row = new boolean[target];
        column = new boolean[target];
        left = new boolean[2 * target - 1];
        right = new boolean[2 * target- 1];

        recursive(0, target);

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();

    }
}