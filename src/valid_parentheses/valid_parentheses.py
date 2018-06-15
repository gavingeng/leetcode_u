#!/usr/bin/env python
# coding:utf-8
# filename:valid_parentheses.py

'''
author:	gavingeng
date:	2018-06-15 08:51:43 
'''


class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # stack = []
        # for str in range(len(s)):
        #     i = s[str]
        #     if i == '(' or i == '[' or i == '{':
        #         stack.append(i)
        #     elif i == ')' and len(stack) > 0 and stack.index('(') == 0:
        #         stack.pop()
        #     elif i == ']' and len(stack) > 0 and stack.index('[') == 0:
        #         stack.pop()
        #     elif i == '}' and len(stack) > 0 and stack.index('{') == 0:
        #         stack.pop()
        #     else:
        #         return False
        #
        # return False if len(stack) > 0 else True

        dict = {'}': '{', ']': '[', ')': '('}
        stack = []

        for c in s:
            if c in dict.values():
                stack.append(c)
            elif c in dict.keys():
                if stack == [] or dict[c] != stack.pop():
                    return False
            else:
                return False

        return stack == []


def main():
    s = Solution()
    str = "[{]}"
    # str = "()[]{}"
    print s.isValid(str)


if __name__ == '__main__':
    main()
