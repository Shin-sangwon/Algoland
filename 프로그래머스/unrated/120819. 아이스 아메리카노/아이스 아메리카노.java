class Solution {
    public int[] solution(int money) {
        
        int answer[] = new int[2];
        
        final int PRICE = 5_500;
        
        answer[0] = money / PRICE;
        answer[1] = money - (PRICE * answer[0]);
        
        return answer;
    }
}