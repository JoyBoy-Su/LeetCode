import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 通过哈希，记录另一半位置
         */
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();//创建一个HashMap集合，Map是键值对的形式，而HashMap是键值唯一
            for (int i = 0; i < nums.length; ++i) {
                if (hashtable.containsKey(target - nums[i])) {//判断每一个值x对应的target-x是不是存在，为什么是containsKey而不是value
                                                              //因为这个map的键值对种是下标是值，键反而是数组中是数值
                    return new int[]{hashtable.get(target - nums[i]), i};//存在就返回两个下标，其中的target-x下标可以用HashMap的get方法获得
                }
                hashtable.put(nums[i], i);//并不是先将所有数据都放进HashMap，而是从第一个数先开始判断，然后再将这个数放进Map中，可以避免自己跟自己匹配
            }                             //而且要注意键值对，谁是键，谁是值
            return new int[0];
    }
}
// @lc code=end

