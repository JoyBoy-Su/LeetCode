import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2100 lang=java
 *
 * [2100] 适合打劫银行的日子
 */

// @lc code=start
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> answer = new ArrayList<Integer>();
        int len = security.length;
        //分别确定前侧和后侧的升降个数
        int[] before = new int[len];
        int pre = 0;
        for(int i = 1; i < len; i++) {
            if(security[i] <= security[i - 1]) pre++;
            else pre = 0;
            before[i] = pre;
        }
        int[] after = new int[len];
        int last = 0;
        for(int i = len - 2; i >= 0; i--) {
            if(security[i] <= security[i + 1]) last++;
            else last = 0;
            after[i] = last;
        }

        //遍历数组，判断前后均大于time的元素
        for(int i = 0; i < len; i++) {
            if(before[i] >= time && after[i] >= time) answer.add(i);
        }

        return answer;
    }
}
// @lc code=end

