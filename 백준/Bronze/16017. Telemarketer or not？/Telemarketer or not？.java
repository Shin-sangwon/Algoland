import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean isValid(int x) {

        return x == 8 || x == 9;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        int third = Integer.parseInt(br.readLine());
        int forth = Integer.parseInt(br.readLine());

        System.out.println( (isValid(first)) && (isValid(forth)) && second == third? "ignore" : "answer");
    }
}
