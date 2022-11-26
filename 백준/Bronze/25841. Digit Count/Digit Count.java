import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());
        int idx = Integer.parseInt(st.nextToken());
        int answer = 0;

        for(int i = start; i <= last; i++) {
            int arr[] = Stream.of(String.valueOf(i).split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == idx) {
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

}