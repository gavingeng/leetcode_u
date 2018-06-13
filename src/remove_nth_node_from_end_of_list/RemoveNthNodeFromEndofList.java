package remove_nth_node_from_end_of_list;

/**
 * Created by gavingeng on 2018-06-12 17:48.
 */

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
	}
}

public class RemoveNthNodeFromEndofList {
	
	/**
	 * 两次循环，第一次获取长度，第二次讲其删除
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 0;
		ListNode tmpNode = new ListNode(0);
		tmpNode.next = head;
		ListNode start = head;
		while (start != null) {
			length++;
			start = start.next;
		}
		
		int del = length - n;
		
		start = tmpNode;
		while (del > 0) {
			del--;
			start = start.next;
		}
		
		start.next = start.next.next;
		
		return tmpNode.next;
	}
	
	/**
	 * 一次遍历，两个指针，间隔n步来做删除，大部分的链表都是这种操作
	 * 加入临时节点 tmpNode，循环遍历是处理空的情况【我竟然没想到......】
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd1(ListNode head, int n) {
		ListNode tmpNode = new ListNode(0);
		tmpNode.next = head;
		ListNode fast = tmpNode;
		ListNode slow = tmpNode;
		
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		
		return tmpNode.next;
	}
	
	
	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
//
//		int n = 2;
		
		ListNode head = new ListNode(1);
		int n = 1;

//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		int n = 2;
		
		ListNode retNode = removeNthFromEnd1(head, n);
		while (retNode != null) {
			System.out.println(retNode.val);
			retNode = retNode.next;
		}
		
	}
}

