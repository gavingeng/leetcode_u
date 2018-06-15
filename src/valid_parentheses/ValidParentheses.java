package valid_parentheses;

import java.util.Stack;

/**
 * Created by gavingeng on 2018-06-15 08:50.
 * 验证括号是否完整
 * link: https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
	
	/**
	 * 利用栈stack来做处理，前半部分满足加入栈，然后判断栈顶元素是否匹配
	 *
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else {
				return false;
			}
		}
		
		return stack.isEmpty();
		
	}
	
	public static void main(String[] args) {
		String s = "()[]{}";
		s = "[(})";
		boolean isValid = isValid(s);
		System.out.println(isValid);
	}
}
