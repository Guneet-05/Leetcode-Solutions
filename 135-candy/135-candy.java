class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        
        left[0] = 1;
        
        for(int i=1;i<left.length;i++) {
            if(ratings[i] > ratings[i-1]) {
                //min inc possible is +1
                left[i] = left[i-1] + 1;
            } else {
                //min candies that can be alloted is 1
                left[i] = 1;
            }
        }
        
        right[ratings.length -1] = 1;
        
        for(int i=ratings.length-2;i>=0;i--) {
            if(ratings[i] > ratings[i+1]) {
                //min inc possible is + 1
                right[i] = right[i+1] + 1;
            } else {
                //min candies that can be alloted is 1
                right[i] = 1;
            }
        }
        
        int res = 0;
        
        for(int i=0;i<left.length;i++) {
            res += Math.max(left[i],right[i]);
        }
        
        return res;
    }
}