import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        while(n-->0) {

            //0 -> 큰 값 출력, 배열에서 제거
            //그 외 -> 삽입
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0) {

                if(q.isEmpty()) {
                    sb.append("0\n");
                    continue;
                }

                sb.append(q.poll()+"\n");
                continue;
            }

            q.add(tmp);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}