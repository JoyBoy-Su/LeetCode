/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    /**
     * 二分查找数据，若不存在刚好查找插入的位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int answer = 0;
        int left = 0, right = nums.length - 1;
        int middle = 0;
        // 二分查找
        while(left <= right) {
            middle = left + (right - left) / 2;     // 避免数组过大相加越界
            if(nums[middle] == target) return middle;
            // 若 middle < target，说明应该取右侧区间
            if(nums[middle] < target) left = middle + 1;
            // 反之，取左侧区间
            else right = middle - 1;
        }
        answer = left;
        return answer;
    }
}
// @lc code=end

