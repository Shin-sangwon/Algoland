import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            k = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }
            Arrays.sort(arr);
            search();
        }
        System.out.print(sb);
    }

    static void search() {
        int left = 0;
        int right = n - 1;
        int index = 200000001;
        int count = 0;

        while (left < right) {
            int now = arr[left] + arr[right];
            if (now <= k) left++;
            else right--;
            int distance = Math.abs(k - now);
            if (distance == index) {
                count++;
            } else if (distance < index) {
                index = Math.abs(k - now);
                count = 1;
            }
        }

        sb.append(count + "\n");
    }
}