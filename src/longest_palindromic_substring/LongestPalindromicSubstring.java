package longest_palindromic_substring;

/**
 * Created by gavingeng on 2018-06-05 16:16.
 */
public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {

		return "";
	}

	public static void main(String[] args) {

		String case1 = "babad";// bab
		String case2 = "cbbd";// bb

		String ret = longestPalindrome(case1);
		System.out.println(ret);
		ret = longestPalindrome(case2);
		System.out.println(ret);
	}
}
