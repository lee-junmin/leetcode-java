import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int nums1[] = { 1, 2, 3, 0, 0, 0 };
        int nums2[] = { 2, 5, 6 };
        int m = 3;
        int n = 3;

        msa.merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, l = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[l--] = nums1[i--];
            } else {
                nums1[l--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[l--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[l--] = nums2[j--];
        }
        System.out.println(Arrays.toString(nums1));
    }
}
