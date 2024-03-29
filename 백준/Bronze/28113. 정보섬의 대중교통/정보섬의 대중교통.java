import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int bus = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int subway = n + (b - n);

        System.out.println(bus != subway? (bus < subway? "Bus" : "Subway") : "Anything");
    }
}
