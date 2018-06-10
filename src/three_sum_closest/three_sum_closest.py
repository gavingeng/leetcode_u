#!/usr/bin/env python
# coding:utf-8
# filename:three_sum_closest.py

'''
author:	gavingeng
date:	2018-06-10 10:12:34
'''


class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums = sorted(nums)
        ret = 0
        minGap = 10 ** 10

        for i in range(len(nums)):
            j = i + 1
            k = len(nums) - 1

            while (j < k):
                sum = nums[i] + nums[j] + nums[k]
                gap = abs(sum - target)
                if gap < minGap:
                    ret = sum
                    minGap = gap

                if sum < target:
                    j += 1
                else:
                    k -= 1

        return ret


def test():
    s = Solution()
    nums = [-1, 2, 1, -4]
    target = 1
    ret = s.threeSumClosest(nums, target)
    print ret


def main():
    test()


if __name__ == '__main__':
    main()
