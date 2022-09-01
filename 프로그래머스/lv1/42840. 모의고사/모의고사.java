import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
    
        int a = 0;
        int b = 0;
        int c = 0;
        
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;
        
        int aArr[] = {1,2,3,4,5};
        int bArr[] = {2,1,2,3,2,4,2,5};
        int cArr[] = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i < answers.length; i++) {
            if(aCnt > 4) aCnt = 0;
            if(bCnt > 7) bCnt = 0;
            if(cCnt > 9) cCnt = 0;
            
            //
            
            if(answers[i] == aArr[aCnt]) a++;
            if(answers[i] == bArr[bCnt]) b++;
            if(answers[i] == cArr[cCnt]) c++;
            
            aCnt++;
            bCnt++;
            cCnt++;
              
            
        }
        
        int max = Math.max(Math.max(a,b), c);
        
        ArrayList<Integer> al = new ArrayList<>();
        
        if(max == a) al.add(1);
        if(max == b) al.add(2);
        if(max == c) al.add(3);
        
        int answer[] = new int[al.size()];
        
        for(int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        
        
        
        
        return answer;
    }
}