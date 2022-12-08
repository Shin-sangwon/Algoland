import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        
        ArrayList<String> al = new ArrayList<>();
        
        int indexCount = 1;
        int otherCount = 0;
        int targetIndex = 0;

        char index = s.charAt(0);

        for(int i = 1; i < s.length(); i++) {

            if(s.charAt(i) == index) {
                indexCount++;
            }

            if(s.charAt(i) != index) {
                otherCount++;
            }

            if(indexCount == otherCount) {
                al.add(s.substring(targetIndex, i+1));
                indexCount = 0;
                otherCount = 0;
                if(i < s.length()-1) {
                    targetIndex = i+1;
                    index = s.charAt(i+1);
                }
            }

            if((i == s.length()-1) && (otherCount != 0 || indexCount != 0)) {
                al.add("tmp");
            }

        }
        
        return s.length() == 1? 1 : al.size();
    }
}