import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String index = br.readLine();

        if(index.equals("NLCS")){
            System.out.println("North London Collegiate School");
            return;
        }

        if(index.equals("BHA")) {
            System.out.println("Branksome Hall Asia");
            return;
        }

        if(index.equals("KIS")) {
            System.out.println("Korea International School");
            return;
        }

        System.out.println("St. Johnsbury Academy");


    }
}
