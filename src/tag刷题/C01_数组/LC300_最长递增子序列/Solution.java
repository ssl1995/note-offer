package tag刷题.C01_数组.LC300_最长递增子序列;

import java.util.Arrays;

public class Solution {
    // 力扣:是返回最长递增子序列的长度

    // 法1：前面<后面，更新dp
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i]：[0..i]组成的最长子序列长度，初始化为1
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int manLen = 1;// 最长连续子序列长度最低为1
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    manLen = Math.max(dp[i], manLen);
                }
            }
        }
        return manLen;
    }

    // 法2：记录第一个>=nums的值，二分加快速度
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // tails[i]记录长度为i+1的最长子序列最后一个数
        int[] tails = new int[nums.length];
        // maxLen是tails遍历下标，也是二分查找右边界的开区间范围
        int maxLen = 0;
        for (int num : nums) {
            // 二分查找变种1，在nums[i]中找第一个>=num的数
            // 注意:right≠arr.len-1，本题right=maxLen。所以改变的有left<right；right=mid
            int left = 0, right = maxLen;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else if (tails[mid] >= num) {
                    right = mid;// 因为right初始化是开区间，所以这里是mid，不是mid+1
                }
            }
            // 遍历结束，left找到在nums[i]中第一个>=num的数
            // tails的[0,maxLen]区间内存在tails[i]>num的数，说明i+1长度下子序列最后一个数更新为num
            tails[left] = num;
            // tails的[0,maxLen]区间内不存在tails[i]>num的数，说明i+1长度下子序列最大值小于num，更新maxLen区间长度
            if (maxLen == right) {
                maxLen++;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {10, 9, 2, 5, 3, 7, 101, 18};
        //   tails = {2, 3, 7, 18, 0, 0, 0, 0};
        System.out.println(solution.lengthOfLIS1(arr1));// 4
        System.out.println(solution.lengthOfLIS2(arr1));// 4
    }
}