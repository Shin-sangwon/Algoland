import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int bigBucket = Integer.parseInt(br.readLine());
        int smallBucket = Integer.parseInt(br.readLine());

        System.out.println(((bigBucket * 8) + (smallBucket * 3)) - 28);
    }
}
