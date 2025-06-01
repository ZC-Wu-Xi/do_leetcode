package algorithm;

/**
 * @author ZC_Wu 汐
 * @date 2025/6/1 16:35
 * @description 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class A4Solution {
    public static void main(String[] args) {
        int[] num1 = {1,9};
        int[] num2 = {2,10,12};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println("medianSortedArrays = " + medianSortedArrays);
    }
    /**
     * 主方法：计算两个有序数组的中位数
     * @param nums1 第一个有序数组
     * @param nums2 第二个有序数组
     * @return 两个数组合并后的中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tot = nums1.length + nums2.length; // 计算两个数组的总长度

        // 根据总长度的奇偶性分别处理
        if (tot % 2 == 0) {
            // 如果是偶数长度，中位数是中间两个数的平均值
            int left = find(nums1, 0, nums2, 0, tot / 2); // 找到第k/2小的数
            int right = find(nums1, 0, nums2, 0, tot / 2 + 1); // 找到第k/2+1小的数
            return (left + right) / 2.0; // 返回平均值
        } else {
            // 如果是奇数长度，中位数就是中间的那个数
            return find(nums1, 0, nums2, 0, tot / 2 + 1); // 找到第k/2+1小的数
        }
    }

    /**
     * 辅助方法：在两个有序数组中找到第k小的元素（二分查找实现）
     * @param nums1 第一个有序数组
     * @param i nums1的起始查找位置
     * @param nums2 第二个有序数组
     * @param j nums2的起始查找位置
     * @param k 要找的第k小的元素
     * @return 第k小的元素值
     */
    private static int find(int[] nums1, int i, int[] nums2, int j, int k) {
        // 保证nums1是较短的数组，这样能减少递归次数
        if (nums1.length - i > nums2.length - j) return find(nums2, j, nums1, i, k);

        // 基准情况1：当k=1时，直接返回两个数组当前元素中的较小值
        if (k == 1) {
            if (i == nums1.length) return nums2[j]; // 如果nums1已遍历完，返回nums2的当前元素
            else return Math.min(nums1[i], nums2[j]); // 否则返回两者中的较小值
        }

        // 基准情况2：如果nums1已遍历完，直接从nums2中取第k小的元素
        if (i == nums1.length) return nums2[j + k - 1];

        /**
         * 我们要找的是第k小的元素，所以我们需要在 nums1 和 nums2 中各自跳过一部分元素，使得剩下的部分仍然可能包含第k小的元素。
         * 为了高效地缩小搜索范围，我们：
         * 在 nums1 中取前 k/2 个元素（记为 nums1[0..si-1]）。
         * 在 nums2 中取前 k - k/2 个元素（记为 nums2[0..sj-1]）。
         * 比较 nums1[si-1] 和 nums2[sj-1]，较小的那一部分可以直接排除，因为它们不可能包含第k小的元素。
         */
        // 计算两个数组的中间位置（注意处理数组越界）
        /**
         * i 是 nums1 当前的起始位置。
         * k / 2 表示我们希望从 nums1 中取 k/2 个元素。
         * Math.min(nums1.length, i + k / 2) 是为了防止越界：
         * 如果 i + k / 2 超过了 nums1 的长度，说明 nums1 剩下的元素不足 k/2 个，我们只能取到 nums1.length。
         */
        int si = Math.min(nums1.length, i + k / 2); // nums1的中间位置
        int sj = j + (k - k / 2); // nums2的中间位置（保证si和sj的总和为k）

        // 比较两个中间位置的元素大小，决定舍弃哪一部分
        if (nums1[si - 1] < nums2[sj - 1]) {
            // 如果nums1的中间元素较小，说明第k小的元素不在nums1的前半部分
            return find(nums1, si, nums2, j, k - (si - i)); // 舍弃nums1的前半部分
        } else {
            // 如果nums2的中间元素较小，说明第k小的元素不在nums2的前半部分
            return find(nums1, i, nums2, sj, k - (sj - j)); // 舍弃nums2的前半部分
        }
    }
}
