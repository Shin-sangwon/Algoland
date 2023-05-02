import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        for(int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int average = (int) Arrays.stream(arr)
            .average()
            .getAsDouble();

        int mode = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(x -> x, TreeMap::new, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(-1);

        System.out.println(average);
        System.out.println(mode);
    }
}
