import java.util.stream.Stream;

class Solution {
    
    public static boolean isNumeric(String x) {

        try {
            Integer.parseInt(x);

        }catch(NumberFormatException e) {
            return false;
        }

        return true;
    }
    
    public int[] solution(String my_string) {
        
        return Stream.of(my_string.split(""))
            .filter(x -> isNumeric(x))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
    }
}