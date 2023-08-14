import static java.lang.Math.pow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

    private static int sum(int n) {


        return IntStream.range(0, n+1).sum();
    }

    private static int sumsum(int n) {

        int sum = IntStream.range(0, n+1).sum();
        return (int) pow(sum, 2);
    }

    private static int sumsumsum(int n) {

        return (int) IntStream.range(0, n+1)
                              .mapToDouble(x -> Math.pow(x, 3))
                              .sum();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        System.out.println(sum(n));
        System.out.println(sumsum(n));
        System.out.println(sumsumsum(n));



    }

}
