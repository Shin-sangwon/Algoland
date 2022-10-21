import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    static final String MESSAGE = "You are speeding and your fine is ";
    public static String calc(int max_speed, int current_speed) {

        int index = current_speed - max_speed;

        if(index <= 0) {
            return "Congratulations, you are within the speed limit!";
        }

        if(index >= 1 && index <= 20) {
            return "%s$100.".formatted(MESSAGE);
        }

        if(index >= 21 && index <= 30) {
            return "%s$270.".formatted(MESSAGE);
        }

        return "%s$500.".formatted(MESSAGE);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MAXIMUM_SPEED = Integer.parseInt(br.readLine());
        final int CURRENT_SPEED = Integer.parseInt(br.readLine());

        bw.write(calc(MAXIMUM_SPEED, CURRENT_SPEED));
        bw.flush();
        bw.close();
        br.close();





    }

}