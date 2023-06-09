import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(br.readLine());
        int idx = Integer.parseInt(br.readLine());

        int answer = (start + idx) % 12;

        System.out.println(answer == 0? 12 : answer);


    }
}
