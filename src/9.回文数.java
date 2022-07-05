/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        /**
         * 将int型数据转成字符串，然后判断字符串
         */
        boolean answer = true;
        String str = String.valueOf(x);
        int length = str.length();
        for(int i = 0; i < length; i++) {
            if(str.charAt(i) != str.charAt(length - 1 - i)) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
// @lc code=end

