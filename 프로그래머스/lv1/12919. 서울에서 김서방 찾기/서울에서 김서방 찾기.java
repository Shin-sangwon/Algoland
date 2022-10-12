import java.util.stream.IntStream;

class Solution {
    public String solution(String[] seoul) {
        final String target = "Kim";
        
        int idx = IntStream.range(0, seoul.length)
            .filter(x -> target.equals(seoul[x]))
            .findFirst()
            .orElse(0);
        
        return "김서방은 " + idx + "에 있다";
    }
}