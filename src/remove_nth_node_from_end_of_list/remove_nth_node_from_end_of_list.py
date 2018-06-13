#!/usr/bin/env python
# coding:utf-8
# filename:remove_nth_node_from_end_of_list.py

'''
author:	gavingeng
date:	2018-06-12 17:47:41 
'''


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        tmpNode = ListNode(0)
        tmpNode.next = head

        fast = tmpNode
        slow = tmpNode

        idx = 0
        while idx < n:
            fast = fast.next
            idx += 1

        while fast.next != None:
            fast = fast.next
            slow = slow.next

        slow.next = slow.next.next

        return tmpNode.next


def test():
    s = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    n = 2
    retNode = s.removeNthFromEnd(head, n)

    while retNode != None:
        print retNode.val
        retNode = retNode.next


def main():
    test()


if __name__ == '__main__':
    main()
