import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {


     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] arr = new long[21];
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i < arr.length; i++) {

            arr[i] = arr[i-1] * i;
        }

         System.out.println(arr[Integer.parseInt(br.readLine())]);



    }
}