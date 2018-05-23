package two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * two sum https://leetcode.com/problems/two-sum/description/
 * Created by gavingeng on 2018-05-23 16:37.
 */
public class TwoSum {

	/**
	 * 时间复杂度 O(n^2)
	 * 空间复杂度 O(1)
	 */
	public static int[] solution1(int[] nums, int target) {
		int[] idxResult = {0, 0};
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					idxResult[0] = i;
					idxResult[1] = j;
				}
			}
		}
		return idxResult;
	}

	public static int[] solution2(int[] nums, int target) {
		int[] idxResult = {0, 0};
		//key:值 value:索引
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int aim = target - nums[i];
			if (map.containsKey(aim)) {
				idxResult[0] = i;
				idxResult[1] = map.get(aim);
			}
		}
		return idxResult;
	}


	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;

//		int[] idxResult = solution1(nums, target);
		int[] idxResult = solution2(nums, target);

		for (int i = 0; i < idxResult.length; i++) {
			System.out.println(idxResult[i]);
		}
	}
}
