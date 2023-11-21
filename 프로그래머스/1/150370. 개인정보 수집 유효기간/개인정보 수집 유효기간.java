import java.util.*;
import java.time.*;
import java.util.stream.*;

class Solution {
    
    static Map<String, Integer> map;
    static LocalDate now;
    static List<Integer> answers;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        init(today, terms);
        calculation(privacies);
        int[] answer = new int[answers.size()];
        
        for(int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
    
    private void calculation(String[] privacies) {
        
        for(int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            
            int[] dateArray = dateParser(str[0]);
            LocalDate date = LocalDate.of(dateArray[0], dateArray[1], dateArray[2]);
            int expiration = map.get(str[1]);
            
            LocalDate expireDate = date.plusMonths(expiration);
            
            if(expireDate.isAfter(now)) continue;
            
            answers.add(i + 1);
        }
    }
    
    private void init(String today, String[] terms) {
        map = new HashMap<>();
        answers = new ArrayList<>();
        for(String x : terms) {
            String[] arr = x.split(" ");
            String key = arr[0];
            int value = Integer.valueOf(arr[1]);
            map.put(key, value);
        }
        
        int[] date = dateParser(today);
        
        now = LocalDate.of(date[0], date[1], date[2]);
        
        
    }
    
    private int[] dateParser(String date) {
        
        return Stream.of(date.split("\\."))
                         .mapToInt(Integer::parseInt)
                         .toArray();
    }
}