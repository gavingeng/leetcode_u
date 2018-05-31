package longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Created by gavingeng on 2018-05-31 16:07.
 */
public class LongestSubString {

	public static int lengthOfLongestSubstring(String s) {
		int length = s.length();
		int ret = 0;
		//key:字符 value:索引
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; j < length; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ret = Math.max(ret, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}

		return ret;
	}

	/**
	 * 这个参考了解决方案来写的，根据字符的特性，128个字节完全可以解决,比map省
	 *
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstringASCII(String s) {
		int length = s.length();
		int ret = 0;
		int[] idx = new int[128];
		for (int i = 0, j = 0; j < length; j++) {
			i = Math.max(idx[s.charAt(j)], i);
			ret = Math.max(ret, j - i + 1);
			idx[s.charAt(j)] = j + 1;
		}

		return ret;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
//		s = "bbbbb";
//		s = "abba";
//		int size = lengthOfLongestSubstring(s);
		int size = lengthOfLongestSubstringASCII(s);
		System.out.println("size=" + size);
	}
}
