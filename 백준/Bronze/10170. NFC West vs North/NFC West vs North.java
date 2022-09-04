import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append("NFC West       W   L  T").append("\n")
                .append("-----------------------").append("\n")
                .append("Seattle        13  3  0").append("\n")
                .append("San Francisco  12  4  0").append("\n")
                .append("Arizona        10  6  0").append("\n")
                .append("St. Louis      7   9  0").append("\n").append("\n")
                .append("NFC North      W   L  T").append("\n")
                .append("-----------------------").append("\n")
                .append("Green Bay      8   7  1").append("\n")
                .append("Chicago        8   8  0").append("\n")
                .append("Detroit        7   9  0").append("\n")
                .append("Minnesota      5  10  1");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();





    }
}