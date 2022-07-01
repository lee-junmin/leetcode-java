package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TC O(n^2)
public class pointerSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length && nums[i] <= 0; i++){
            if ( i == 0 || nums[i] != nums[i-1]){

                int lo = i + 1;
                int hi = nums.length - 1;
                while (lo < hi){
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (0 > sum){
                        lo++;
                    } else if (sum > 0) {
                        hi--;
                    } else { // match
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[lo], nums[hi])));
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo] == nums[lo - 1]){
                            lo++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
