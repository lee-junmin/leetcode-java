package medianOfTwoSortedArrays;
// TC O(log min(m,n) ) where m and n is the length of each input
// SC  O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 < len2) return findMedianSortedArrays(nums2,nums1);

        int partitionSize = (len1 + len2) / 2;

        int left = 0, right = len2 -  1;

        while (true) {
            int nums2Part  = Math.floorDiv(right + left,2);
            int nums1Part = partitionSize - nums2Part - 2;

            int nums1Left = nums1Part >= 0 ? nums1[nums1Part] : Integer.MIN_VALUE;
            int nums2Left = nums2Part >= 0 ? nums2[nums2Part] : Integer.MIN_VALUE;
            int nums1Right = nums1Part < len1 - 1 ? nums1[nums1Part + 1] : Integer.MAX_VALUE;
            int nums2Right = nums2Part < len2 - 1 ? nums2[nums2Part + 1] : Integer.MAX_VALUE;

            if (nums1Left <= nums2Right && nums2Left <= nums1Right){
                if ((len1 + len2) % 2 == 1) return (double)Math.min(nums1Right, nums2Right);
                return (double)(Math.max(nums1Left,nums2Left) + Math.min(nums1Right,nums2Right))/2;
            } else if (nums2Left > nums1Right) {
                right = nums2Part - 1;
            } else  {
                left = nums2Part + 1;
            }
        }
    }
}