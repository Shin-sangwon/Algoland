import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    private static String calc(int[] arr) {

        if(arr[0] == 0 && arr[1] == 1 && arr[2] == 1 || arr[0] == 1 && arr[1] == 0 && arr[2] == 0) return "A";
        if(arr[0] == 1 && arr[1] == 0 && arr[2] == 1 || arr[0] == 0 && arr[1] == 1 && arr[2] == 0) return "B";
        if(arr[0] == 1 && arr[1] == 1 && arr[2] == 0 || arr[0] == 0 && arr[1] == 0 && arr[2] == 1) return "C";
        return "*";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(calc(Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()));

    }
}
