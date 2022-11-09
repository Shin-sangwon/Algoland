class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char arr[] = s.toCharArray();
        
        if(arr.length == 4 || arr.length == 6) {
            
            for(char x : arr) {
                
                try {
                    Integer.parseInt(String.valueOf(x));
                } catch (NumberFormatException e) {
                    answer = false;
                    break;
                }
            }
            
        }
        
        return arr.length == 4 || arr.length == 6? answer : false;
    }
}