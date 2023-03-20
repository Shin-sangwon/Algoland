import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BigInteger bl = new BigInteger(br.readLine());
        BigInteger diff = new BigInteger(br.readLine());
        
        BigInteger x = (bl.add(diff)).divide(new BigInteger("2"));
        BigInteger y = bl.subtract(x);
        System.out.println(x);
        System.out.println(y);
    }
}
