import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int size = Integer.parseInt(br.readLine());

        while(true) {

            int n = Integer.parseInt(br.readLine());

            if(n == -1) {
                break;
            }

            if(n != 0 && queue.size() >= size) {
                continue;
            }

            if(n == 0) {
                queue.poll();
                continue;
            }

            queue.add(n);

        }

        if(queue.size() == 0) {
            sb.append("empty");
        }else {
            while(!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}