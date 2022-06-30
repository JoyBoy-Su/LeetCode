/*
 * @lc app=leetcode.cn id=2055 lang=java
 *
 * [2055] 蜡烛之间的盘子
 */

// @lc code=start
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = queries.length;
        int strLen = s.length();
        int[] answer = new int[len];

        int[] pres = new int[strLen];   //盘子前缀和
        int[] lefts = new int[strLen];  //左侧第一个蜡烛
        int[] rights = new int[strLen]; //右侧第一个蜡烛
        //确定前缀和以及左侧第一个蜡烛
        int pre = 0;
        int left = -1;

        for(int i = 0; i < strLen; i++) {
            if(s.charAt(i) == '|') {
                pres[i] = pre;
                left = i;
                lefts[i] = left;
            } else  {
                pre++;
                lefts[i] = left;
            }
        }
        //确定右侧第一个蜡烛
        int right = strLen;
        for(int i = strLen - 1; i >= 0; i--) {
            if(s.charAt(i) == '|') {
                right = i;
            }
            rights[i] = right;
        }

        //确定每个查找的结果
        for(int i = 0; i < len; i++) {
            //确定查找的子串范围
            int start = queries[i][0];
            int end = queries[i][1];
            // start更新为目标查询范围左侧端点右侧第一个蜡烛，即最左侧蜡烛索引
            // end更新为目标查询范围右侧端点左侧第一个蜡烛，即最右侧蜡烛索引
            start = rights[start];
            end = lefts[end];
            if(start < 0 || start >= strLen || end < 0 || end >= strLen || start > end) answer[i] = 0;
            else answer[i] = pres[end] - pres[start];
        }

        return answer;
    }
}
// @lc code=end

