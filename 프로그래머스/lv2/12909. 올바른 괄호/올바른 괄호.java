import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
                continue;
            }
            
            if(s.charAt(i) == ')' && stack.size() == 0) {
                answer = false;
                break;
            }
            
            if(s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            
            
            answer = false;
            break;
            
            
        }
        
        if(stack.size() != 0) answer = false;

        return answer;
    }
}