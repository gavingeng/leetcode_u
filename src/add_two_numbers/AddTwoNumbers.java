package add_two_numbers;

/**
 * Created by gavingeng on 2018-05-28 17:08.
 */
public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode retNode = new ListNode(-1);
		ListNode curNode = retNode;
		//进位
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = l1 == null ? 0 : l1.val;
			int y = l2 == null ? 0 : l2.val;
			int v = carry + x + y;
			curNode.next = new ListNode(v % 10);
			carry = v / 10;
			curNode = curNode.next;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		if (carry > 0)
			curNode.next = new ListNode(carry);
		return retNode.next;
	}

	public static ListNode reverse(ListNode head) {
		if (head == null)
			return head;

		ListNode pre = head;
		ListNode cur = head.next;
		ListNode tmp;
		while (cur != null) {
			tmp = cur.next;
			cur.next = pre;

			pre = cur;
			cur = tmp;
		}
		head.next = null;
		return pre;
	}

	public static void print(ListNode head) {
		StringBuffer buffer = new StringBuffer();
		while (head != null) {
			buffer.append(head.val);
			head = head.next;
		}
		System.out.println(buffer.toString());
	}

	public static void test() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(9);

		ListNode ret = addTwoNumbers(l1, l2);
		ListNode head = reverse(ret);
		print(head);
	}

	public static void test1() {
		ListNode l1 = new ListNode(5);

		ListNode l2 = new ListNode(5);

		ListNode ret = addTwoNumbers(l1, l2);
		ListNode head = reverse(ret);
		print(head);
	}

	public static void main(String[] args) {
//		test();
		test1();
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}