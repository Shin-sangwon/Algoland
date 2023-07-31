import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    private static boolean isEven(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) continue;

            if(arr[i] % 2 != 0) return false;
        }

        return true;

    }

    private static boolean isOdd(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) continue;

            if(arr[i] % 2 != 1) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];

        br.readLine().chars()
            .map(c -> c - 97)
            .forEach(x -> arr[x]++);


        if(isEven(arr)) {
            System.out.println(0);
        }else if(isOdd(arr)) {
            System.out.println(1);
        }else {
            System.out.println(2);
        }


    }

}
