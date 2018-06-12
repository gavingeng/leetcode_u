#!/usr/bin/env python
# coding:utf-8
# filename:four_sum.py

'''
author:	gavingeng
date:	2018-06-11 11:34:28 
'''


class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        retList = list()

        for i in range(len(nums) - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            for j in range(i + 1, len(nums) - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                k = j + 1
                m = len(nums) - 1

                while k < m:
                    sum = nums[i] + nums[j] + nums[k] + nums[m]
                    if sum < target:
                        k += 1
                        while k < m and nums[k] == nums[k - 1]:
                            k += 1
                    elif sum > target:
                        m -= 1
                        while k < m and nums[m] == nums[m + 1]:
                            m -= 1
                    elif sum == target:
                        inner = [nums[i], nums[j], nums[k], nums[m]]
                        retList.append(inner)
                        k += 1
                        m -= 1
                        while k < m and nums[k] == nums[k - 1]:
                            k += 1
                        while k < m and nums[m] == nums[m + 1]:
                            m -= 1

        return retList


def test():
    # nums = [1, 0, -1, 0, -2, 2]
    # nums=[-3, -1, 0, 2, 4, 5]
    # nums=[0, 0, 0, 0]
    nums = [-3, -2, -1, 0, 0, 1, 2, 3]
    target = 0
    s = Solution()
    retList = s.fourSum(nums, target)
    for inner in retList:
        print inner


def test2():
    nums = [-1, 2, 2, -5, 0, -1, 4]
    target = 3
    s = Solution()
    retList = s.fourSum(nums, target)
    for inner in retList:
        print inner


def main():
    test()
    print "*" * 20
    test2()


if __name__ == '__main__':
    main()
