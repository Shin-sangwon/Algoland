import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        // 자연수 > 값 추가, 0이라면 > 배열에서 가장 작은 값 출력 후 제거, 비어있는데 출력해야 한다면 -> 0 출력
        while(n--> 0) {
            int tmp = Integer.parseInt(br.readLine());

            if(tmp == 0 && pq.isEmpty()) {
                sb.append(0 + "\n");
                continue;
            }

            if(tmp == 0) {
                sb.append(pq.poll()+"\n");
                continue;
            }

            pq.add(tmp);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
