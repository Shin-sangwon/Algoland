import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {

    static int[] arr;

    private static boolean calc() {

        return Arrays.stream(arr)
                     .anyMatch(x -> x == 0);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int tc = 1;

        while(n-->0) {
            int in = Integer.parseInt(br.readLine());
            int idx = 0;
            arr = new int[10];
            while(calc()) {
                idx += in;

                String[] split = String.valueOf(idx).split("");

                Stream.of(split)
                      .mapToInt(Integer::parseInt)
                      .forEach(x -> arr[x] = 1);
                
            }

            sb.append(String.format("#%d %d\n", tc++, idx));
        }


        System.out.print(sb);
    }


}
