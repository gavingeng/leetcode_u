package median_of_two_sorted_arrays;

/**
 * link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * Created by gavingeng on 2018-06-01 11:54.
 */
public class MedianOfTwoSortedArrays {

	/**
	 * 经常出现java.lang.ArrayIndexOutOfBoundsException，看来一直无法成功
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int total = l1 + l2;
		int count = 0;

		double ret = 0.0d;

		int i = 0, j = 0;
		int pre = 0;
		while (i < l1 || j < l2) {
			int tmpI = i;
			int tmpJ = j;
			if (nums1[i] >= nums2[j]) {
				pre = nums2[j];
				tmpJ++;
			} else {
				pre = nums1[i];
				tmpI++;
			}
			count++;
			if (total % 2 != 0) {
				if (count > total / 2) {
					ret = pre;
					break;
				}
			} else {
				if (count == total / 2) {
					ret = pre;
					int next = 0;
					if (tmpI > i && tmpI <= l1) {
						next = nums2[j];
					} else {
						next = nums1[i];
					}

					ret += next;

					ret = ret / 2.0;
					break;
				}
			}

			i = tmpI;
			j = tmpJ;
		}

		return ret;
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4, 5};
		double d = findMedianSortedArrays(nums1, nums2);
		System.out.println(d);
	}
}
