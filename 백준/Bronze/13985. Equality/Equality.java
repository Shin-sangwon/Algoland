import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean calc(String[] arr) {

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        int c = Integer.parseInt(arr[4]);

        return a + b == c;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        System.out.println(calc(arr)? "YES" : "NO");
        
    }
}
