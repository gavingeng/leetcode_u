#!/usr/bin/env python
#coding:utf-8
#filename:two_sum.py

'''
author:	gavingeng
date:	2018-05-23 17:16:04 
'''

def solution1(nums,target):
    for i in range(len(nums)-1):
        #print "i=%s" %i 
        for j in range(i+1,len(nums)):
            #print "j=%s" %j
            if target - nums[i] == nums[j] :
                return i,j

def solution2(nums,target):
    data = dict()
    for i in range(len(nums)):
        data[nums[i]] = i

    for i in range(len(nums)):
        aim = target - nums[i]
        if data.has_key(aim):
            return i,data.get(aim)

def solution3(nums,target):
    data = dict()

    for i in range(len(nums)):
        aim = target - nums[i]
        if data.has_key(aim):
            return i,data.get(aim)

        data[nums[i]] = i


def main():
    nums=[2, 7, 11, 15]
    target = 9
    #i,j = solution1(nums,target)
    #i,j = solution2(nums,target)
    i,j = solution3(nums,target)
    print "idx:%s %s" %(i,j)

if __name__=='__main__':
	main()
