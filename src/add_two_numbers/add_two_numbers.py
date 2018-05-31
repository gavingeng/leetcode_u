#!/usr/bin/env python
# coding:utf-8
# filename:add_two_numbers.py

'''
author:	gavingeng
date:	2018-05-31 01:01:22 
'''


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        '''
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        '''
        retNode = ListNode(-1)
        curNode = retNode

        carry = 0

        while (l1 != None or l2 != None):
            x = 0 if l1 == None else l1.val
            y = 0 if l2 == None else l2.val
            sum = carry + x + y
            curNode.next = ListNode(sum % 10)
            carry = sum / 10
            curNode = curNode.next
            l1 = None if l1 == None else l1.next
            l2 = None if l2 == None else l2.next

        return retNode.next

    def show(self, node):
        while (node != None):
            print node.val
            node = node.next


def test():
    l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)

    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)
    l2.next.next.next = ListNode(9)

    s = Solution()
    node = s.addTwoNumbers(l1, l2)
    s.show(node)


def main():
    test()


if __name__ == '__main__':
    main()
