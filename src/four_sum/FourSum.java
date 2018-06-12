package four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gavingeng on 2018-06-11 11:35.
 */
public class FourSum {
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> retList = new ArrayList<>();
		
		for (int i = 0; i < nums.length - 1; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int k = j + 1;
				int m = nums.length - 1;
				
				while (k < m) {
					int sum = nums[i] + nums[j] + nums[k] + nums[m];
					if (sum < target) {
						k++;
						while (nums[k] == nums[k - 1] && k < m)
							k++;
					} else if (sum > target) {
						m--;
						while (nums[m] == nums[m + 1] && k < m)
							m--;
					} else {
						retList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
						k++;
						m--;
						while (nums[k] == nums[k - 1] && k < m)
							k++;
						while (nums[m] == nums[m + 1] && k < m)
							m--;
					}
					
				}
				
			}
			
		}
		return retList;
	}
	
	public static void main(String[] args) {
//		int[] nums = {1, 0, -1, 0, -2, 2};
//		int[] nums = {-3, -1, 0, 2, 4, 5};
//		int[] nums = {0, 0, 0, 0};
//		int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
//		int target = 0;
		
		int[] nums = {-1, 2, 2, -5, 0, -1, 4};
		int target = 3;
		List<List<Integer>> retList = fourSum(nums, target);
		for (List<Integer> inner : retList) {
			StringBuffer buffer = new StringBuffer();
			for (Integer i : inner) {
				buffer.append(i + "\t");
			}
			System.out.println(buffer.toString());
		}
	}
}
