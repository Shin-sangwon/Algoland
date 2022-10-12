import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


public class Main {

    static StringBuilder sb;
    static int index = 1;
    static void print(int max, int min, int gap) {
        sb.append("Class ").append(index++ + "\n").append("Max %d, Min %d, Largest gap %d".formatted(max, min, gap)).append("\n");
    }

    static int findLargeGap(int[] arr) {
       int gap = Integer.MIN_VALUE;

       for(int i = arr.length-1; i > 0; i--) {
           if(arr[i] - arr[i-1] > gap) {
               gap = arr[i] - arr[i-1];
           }
       }

       return gap;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-->0) {

            int arr[] = Stream.of(br.readLine().split(" "))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            int min = arr[0];
            int max = arr[arr.length-1];
            int largeGap = findLargeGap(arr);


            print(max, min, largeGap);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }


}