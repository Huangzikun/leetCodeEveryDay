package day_20200628;

public class LeetCode_209 {

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;

        //尾指针向前
        while (end < n) {
            sum += nums[end];

            //数量超了，开始移动头指针，到小于为止
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start ++;
            }

            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
