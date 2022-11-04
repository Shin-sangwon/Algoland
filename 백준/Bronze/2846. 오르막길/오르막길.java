import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();

        int arr[] = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int min = arr[0];
        int max = 0;
        int answer = Integer.MIN_VALUE;

        for(int i = 1; i < arr.length; i++) {
            //case 1 : 오르막 수 일 경우
            if(arr[i] > arr[i-1]) {
                if(i == arr.length-1) {
                    max = arr[i];
                    answer = Math.max(answer, max - min);
                    continue;
                }
                max = arr[i];
                continue;
            }

            //case 2 : 수가 끊길 경우
            if(arr[i] <= arr[i-1]) {
                answer = Math.max(answer, max - min);
                min = arr[i];
                continue;
            }
        }

        bw.write(answer >= 0? String.valueOf(answer) : "0");
        bw.flush();
        bw.close();
        br.close();


    }

}