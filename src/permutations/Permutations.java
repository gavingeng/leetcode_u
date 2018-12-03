package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 *
 * @author: gavingeng
 * @create: 2018-12-03 14:43
 **/
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
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

            list.add(nums[i]);
            visted[i] = 1;
            permutes(res, visted, list, nums);
            list.remove(list.size() - 1);
            visted[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = permute(nums);

        System.out.println(list);
    }

}
