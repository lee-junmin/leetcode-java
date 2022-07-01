package kokoEatingBananas;

// TC O(n log m) m is the max value of piles, n is length of piles
// SC O(1)

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;

        for (int i: piles){
            if (max < i)  max = i;
        }

        int left = 1;
        int right = max;

        int midVal = 0;

        while (left < right){
            int mid = left + (right - left) / 2;
            midVal = getHours(piles,mid);

            if (midVal <= h){
                right = mid;
            } else if (midVal > h){
                left = mid + 1;
            }
        }

        return left;

    }

    private int getHours(int[] piles, int speed){
        int sum = 0;
        for(int i: piles){
            if (i % speed == 0){
                sum += i / speed;
            } else {
                sum += i / speed + 1;
            }
        }
        return sum;
    }
}