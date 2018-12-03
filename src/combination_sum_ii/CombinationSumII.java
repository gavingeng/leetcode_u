package combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * dfs的用例可真多啊
 *
 * @author: gavingeng
 * @create: 2018-12-03 23:07
 **/
public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, target, path, res);
        return res;
    }

    private static void dfs(int[] candidates, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        if (target < 0) return;
        for (int i = cur; i < candidates.length; i++) {
            if (i > cur && candidates[i] == candidates[i - 1]) continue;
            path.add(path.size(), candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> list = combinationSum2(candidates, target);
        System.out.println(list);
    }
}
