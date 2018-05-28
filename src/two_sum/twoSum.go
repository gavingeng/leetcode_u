package main

import "fmt"

func solution1(nums []int, target int) []int {
	ret := []int{0, 0}
	for i := 0; i < len(nums)-1; i++ {
		for j := i + 1; j < len(nums); j++ {
			if target-nums[j] == nums[i] {
				ret[0] = i
				ret[1] = j
				return ret
			}
		}
	}

	return ret
}

func solution2(nums []int, target int) []int {
	ret := []int{0, 0}
	data := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		data[nums[i]] = i
	}

	for i := 0; i < len(nums); i++ {
		tar := target - nums[i]
		v, exists := data[tar]
		if exists {
			ret[0] = i
			ret[1] = v
			return ret
		}
	}
	return ret

}

func solution3(nums []int, target int) []int {
	ret := []int{0, 0}
	data := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		tar := target - nums[i]
		v, exist := data[tar]
		if exist {
			ret[0] = i
			ret[1] = v
			return ret
		} else {
			data[nums[i]] = i
		}
	}

	return ret
}

func printArray(ret []int) {
	for i := 0; i < len(ret); i++ {
		println("i=", i, "|data=", ret[i])
	}
}

func main() {
	fmt.Println("two-sum")
	nums := []int{2, 7, 11, 15}
	target := 9

	//ret := solution1(nums, target)
	//ret := solution2(nums, target)
	ret := solution3(nums, target)

	printArray(ret)
}
