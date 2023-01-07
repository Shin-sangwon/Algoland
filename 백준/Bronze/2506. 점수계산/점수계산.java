import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n+1];
        int answer[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 1) {

                if(i == 1) {
                    answer[i] = 1;
                    continue;
                }

                answer[i] = answer[i-1] + 1;

            }
        }
        

        bw.write(String.valueOf(IntStream.of(answer).sum()));
        bw.flush();
        bw.close();
        br.close();



    }
}