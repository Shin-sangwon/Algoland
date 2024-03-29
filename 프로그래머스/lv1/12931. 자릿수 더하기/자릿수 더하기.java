import java.util.stream.Stream;

public class Solution {
    public int solution(int n) {
        String tmp = String.valueOf(n);

        return Stream.of(tmp.split(""))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}