package median_of_two_sorted_arrays;

/**
 * link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * Created by gavingeng on 2018-06-01 11:54.
 */
public class MedianOfTwoSortedArrays {
	
	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		//确保m<=n
		if (m > n) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			
			int tmp = m;
			m = n;
			n = tmp;
		}
		
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			
			if (i < iMax && nums2[j - 1] > nums1[i]) {
				iMin = iMin + 1;
			} else if (i > iMin && nums1[i - 1] > nums2[j]) {
				iMax = iMax - 1;
			} else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = nums2[j - 1];
				} else if (j == 0) {
					maxLeft = nums1[i - 1];
				} else {
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}
				
				int minRight = 0;
				if (i == m) {
					minRight = nums2[j];
				} else if (j == n) {
					minRight = nums1[i];
				} else {
					minRight = Math.max(nums2[j], nums1[i]);
				}
				
				return (maxLeft + minRight) / 2.0;
			}
		}
		
		return 0.0;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4, 5};
		double d = findMedianSortedArrays1(nums1, nums2);
		System.out.println(d);
	}
}
