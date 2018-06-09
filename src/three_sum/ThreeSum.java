package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * link https://leetcode.com/problems/3sum/
 * Created by gavingeng on 2018-06-08 11:48.
 */
public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> retList = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			
			int j = i + 1;
			int k = nums.length - 1;
			int target = 0 - nums[i];
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					retList.add(Arrays.asList(nums[i], nums[j], nums[k]));
					
					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}
					while (j < k && nums[k] == nums[k - 1]) {
						k--;
					}
					j++;
				} else {
					if (nums[k] + nums[j] < target) {
						j++;
					} else {
						k--;
					}
				}
				
			}
			
			while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
				i++;
			}
			
		}
		return retList;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
//		int[] nums = {1, -1, -1, 0};
		List<List<Integer>> retList = threeSum(nums);
		for (List<Integer> list : retList) {
			StringBuffer buffer = new StringBuffer();
			for (Integer i : list) {
				buffer.append(i + "\t");
			}
			System.out.println(buffer.toString());
		}
	}
}
