class Solution {
    public int reverse(int x) {
        int temp=Math.abs(x);
        int rev=0;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        if(x>=max || x<=min){
            return 0;
        }

        while(temp>0){
            int i=temp%10;
             // Check for overflow before multiplying or adding
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && i > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && i < -8)) return 0;
            rev=(rev*10)+i;
            temp/=10;
        }
        
        if(x<0){
            rev=-rev;
        }
        return rev;
    }
}