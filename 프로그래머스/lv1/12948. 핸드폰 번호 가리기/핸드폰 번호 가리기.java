class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder().append(phone_number);
            
        return sb.replace(0, sb.length()-4, "*".repeat(sb.length()-4)).toString();
    }
}