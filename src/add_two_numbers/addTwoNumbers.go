package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	retNode := ListNode{Val: -1}
	curNode := retNode

	carry := 0

	for l1 != nil || l2 != nil {
		x := 0
		if l1 != nil {
			x = l1.Val
		}

		y := 0
		if l2 != nil {
			y = l2.Val
		}
		sum := carry + x + y
		curNode.Next = &ListNode{Val: sum % 10}
		carry = sum / 10
		curNode = *curNode.Next
		if l1 != nil {
			l1 = l1.Next
		} else {
			l1 = nil
		}
		if l2 != nil {
			l2 = l2.Next
		} else {
			l2 = nil
		}
	}

	if carry > 0 {
		curNode.Next = &ListNode{Val: carry}
	}

	return retNode.Next
}

func show(node *ListNode) {
	for node != nil {
		fmt.Println(node.Val)
		node = node.Next
	}
}

func test() {
	l1 := ListNode{Val: 2, Next: nil}
	l1.Next = &ListNode{Val: 4, Next: nil}
	l1.Next.Next = &ListNode{Val: 3, Next: nil}

	l2 := ListNode{Val: 5, Next: nil}
	l2.Next = &ListNode{Val: 6, Next: nil}
	l2.Next.Next = &ListNode{Val: 4, Next: nil}
	l2.Next.Next.Next = &ListNode{Val: 9, Next: nil}

	node := addTwoNumbers(&l1, &l2)
	show(node)
}

func test1() {
	l1 := ListNode{Val: 5, Next: nil}
	l2 := ListNode{Val: 5, Next: nil}

	node := addTwoNumbers(&l1, &l2)
	show(node)
}

func main() {
	test()
	//test1()
}
