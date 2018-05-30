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
			int v = carry + l1.val + l2.val;
			curNode.next = new ListNode(v % 10);
			carry = v / 10;
			curNode = curNode.next;
			l1 = l1.next;
			l2 = l2.next;
		}
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


	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode ret = addTwoNumbers(l1, l2);
		ListNode head = reverse(ret);
		print(head);

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}