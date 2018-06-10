package three_sum_closest;

import java.util.Arrays;

/**
 * Created by gavingeng on 2018-06-10 10:12.
 */
public class ThreeSumClosest {
	
	/**
	 * 排序，然后左右夹逼
	 * 比3sum多引入一个间隔minGap，用这个来判断接近程度
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		int ret = 0;
		int minGap = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int gap = Math.abs(sum - target);
				if (gap < minGap) {
					ret = sum;
					minGap = gap;
				}
				
				if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
//		int[] nums = {-1, 2, 1, -4};
//		int target = 1;
		int[] nums = {1, 1, 1, 0};
		int target = 2;
		int ret = threeSumClosest(nums, target);
		System.out.println(ret);
	}
}
