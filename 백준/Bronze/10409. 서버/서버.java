import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        Stream.of(br.readLine()
                    .split(" "))
              .map(Integer::valueOf)
              .forEach(queue::add);

        int answer = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(t - now < 0) break;

            t -= now;
            answer++;
        }

        System.out.println(answer);
    }
}
