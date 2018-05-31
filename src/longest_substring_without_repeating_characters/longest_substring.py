#!/usr/bin/env python
# coding:utf-8
# filename:longest_substring.py

'''
author:	gavingeng
date:	2018-06-01 01:11:00 
'''


def lengthOfLongestSubstring(s):
    """
    :type s: str
    :rtype: int
    """

    data = dict()
    ret = 0

    i = -1
    for j, v in enumerate(s):
        if v in data:
            if data[v] > i:
                i = data[v]

        data[v] = j
        ret = j - i if j - i > ret else ret

    return ret


def test():
    s = "abba"
    # s = "abcabcbb"
    ret = lengthOfLongestSubstring(s)
    print ret


def main():
    test()


if __name__ == '__main__':
    main()
