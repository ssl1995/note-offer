package 刷题笔记.力扣.热门100.LC11_盛水最多的容器;

/**
 * @author SongShengLin
 * @date 2022/1/20 8:14 AM
 * @description
 */
public class Solution {
    /**
     * 盛水最多的容器
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int max;
            // 面积变大只需要移动短板，因为短板处移动才可能变大面积
            if (height[left] < height[right]) {
                max = (right - left) * height[left++];
            } else {
                max = (right - left) * height[right--];
            }
            maxArea = Math.max(maxArea, max);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height));
    }
}
