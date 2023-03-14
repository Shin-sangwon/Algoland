import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[5];

        for(int i = 0; i < 5; i++) arr[i] = br.readLine();

        int start = 0;

        while(start != 15) {

            for(int i = 0; i < 5; i++) {
                if(arr[i].length() < start + 1) continue;

                sb.append(arr[i].charAt(start));
            }

            start++;
        }

        System.out.println(sb);
    }
}
