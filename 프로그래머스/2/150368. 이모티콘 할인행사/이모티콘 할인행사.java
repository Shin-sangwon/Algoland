class Solution {

    static int count = 0;
    static int amount = 0;
    static int[] numbers;
    static double[] discountRatio;
    static int[] discountAmount;

    public int[] solution(int[][] users, int[] emoticons) {

        init(emoticons.length);
        recursive(0, users, emoticons);

        return new int[]{count, amount};
    }

    private void init(int n) {
        numbers = new int[n];
        discountRatio = new double[]{0.9, 0.8, 0.7, 0.6};
        discountAmount = new int[]{10, 20, 30, 40};
    }

    private void recursive(int position, int[][] users, int[] emoticons) {

        if(position == emoticons.length) {
            calculation(users, emoticons);
            return;
        }

        for(int i = 0; i < 4; i++) {
            numbers[position] = i;
            recursive(position + 1, users, emoticons);
        }
    }

    private void calculation(int[][] users, int[] emoticons) {

        int[] discountEmoticons = emoticonPriceCalculator(emoticons);

        int subscriber = 0;
        int totalAmount = 0;

        for(int[] user: users) {

            int userRatio = user[0];
            int userAmount = user[1];
            int userBuyEmoticonPrice = 0;
            for(int j = 0; j < discountEmoticons.length; j++) {

                if(userRatio <= discountAmount[numbers[j]]) {
                    userAmount -= discountEmoticons[j];
                    userBuyEmoticonPrice += discountEmoticons[j];
                }
            }

            if(user[1] <= userBuyEmoticonPrice && userAmount != user[1]) {
                subscriber++;
            }else{
                totalAmount += userBuyEmoticonPrice;
            }


        }

        if(subscriber > count) {
            count = subscriber;
            amount = totalAmount;
        }else if(subscriber == count) {
            amount = Math.max(amount, totalAmount);
        }

    }

    private int discount(int amount, int ratio) {
        return (int) ((amount * (100 - discountAmount[ratio])) / 100);
    }

    private int[] emoticonPriceCalculator(int[] emoticons) {

        int[] discountEmoticons = new int[emoticons.length];

        for(int i = 0; i < emoticons.length; i++) {
            discountEmoticons[i] = discount(emoticons[i], numbers[i]);
        }

        return discountEmoticons;
    }
    
}
    