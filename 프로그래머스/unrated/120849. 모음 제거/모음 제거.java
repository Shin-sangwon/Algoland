class Solution {
    
    static final char[] INDEX_ARRAY = {'a', 'e', 'i', 'o', 'u'};
    
    
    boolean checker(char tmp) {
        
        for(char x : INDEX_ARRAY) {
            if(x == tmp) return true;
        }
        
        return false;
    }
    
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++) {
            if(checker(my_string.charAt(i))) continue;
            
            sb.append(my_string.charAt(i));
        }
        
        
        return sb.toString();
    }
}