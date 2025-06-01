package algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ZC_Wu 汐
 * @date 2025/6/1 13:32
 * @description 两数之和
 */
public class A1Solution {
    /*
        示例 1：
        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

        示例 2：
        输入：nums = [3,2,4], target = 6
        输出：[1,2]

        示例 3：
        输入：nums = [3,3], target = 6
        输出：[0,1]

        提示：
        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        只会存在一个有效答案
        进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     */
    public static void main(String[] args) {
        A1Solution a1Solution = new A1Solution();
        int[] a = new int[]{2,3,4,5,6,7};
        int[] twoSum = a1Solution.twoSum2(a, 7);
        System.out.println(twoSum[0] + "，" +  twoSum[1]);
    }

    /**
     *  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *  你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
     *  你可以按任意顺序返回答案。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] resIndexArr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    resIndexArr[0] = i;
                    resIndexArr[1] = j;
                }
            }
        }
        return resIndexArr;
    }
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int t=target-nums[i];
            if(map.containsKey(t)){
                return new int[]{map.get(t),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
