#!/usr/bin/env python
# coding:utf-8
# filename:three_sum.py

'''
author:	gavingeng
date:	2018-06-09 20:49:50 
'''


def threeSum(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """

    nums = sorted(nums)
    ret = list()

    jump = 0

    for i in range(len(nums) - 2):

        if i < jump:
            continue

        target = 0 - nums[i]
        j = i + 1
        k = len(nums) - 1

        while (j < k):
            if target == nums[j] + nums[k]:
                inner = [nums[i], nums[j], nums[k]]
                ret.append(inner)

                while (j < k and nums[j] == nums[j + 1]):
                    j += 1

                while (j < k and nums[k] == nums[k - 1]):
                    k -= 1

                j += 1
            else:
                if nums[j] + nums[k] < target:
                    j += 1
                else:
                    k -= 1
        while (i < len(nums) - 2 and nums[i] == nums[i + 1]):
            i += 1
            jump = i + 1

    return ret


def test():
    nums = [-1, 0, 1, 2, -1, -4]
    # nums = [1, -1, -1, 0]
    # nums = [-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6]
    ret = threeSum(nums)

    for inner in ret:
        print inner


def main():
    test()


if __name__ == '__main__':
    main()
