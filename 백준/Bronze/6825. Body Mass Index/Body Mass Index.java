import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static String calc(double answer) {

        if(answer > 25) {
            return "Overweight";
        }

        if(answer < 18.5) {
            return "Underweight";
        }

        return "Normal weight";

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());

        double answer = weight / (height * height);

        System.out.println(calc(answer));



    }
}