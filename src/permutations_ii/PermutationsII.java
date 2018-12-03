package permutations_ii;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/
 *
 * @author: gavingeng
 * @create: 2018-12-03 15:59
 **/
public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] visted = new int[nums.length];
        permutes(res, visted, new ArrayList<>(), nums);
        return res;
    }

    public static void permutes(List<List<Integer>> res, int[] visted, ArrayList list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visted[i] == 1)
                continue;

            if (i > 0 && nums[i - 1] == nums[i] && visted[i - 1] == 0) continue;

            list.add(nums[i]);
            visted[i] = 1;

            permutes(res, visted, list, nums);
            list.remove(list.size() - 1);
            visted[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2};
        List<List<Integer>> list = permuteUnique(nums);

        System.out.println(list);
    }
}
