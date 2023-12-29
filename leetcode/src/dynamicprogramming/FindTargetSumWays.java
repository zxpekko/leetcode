package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:给定一个正整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 * @Date:10:08 2023/11/30
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        System.out.println(findTargetSumWays.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public int findTargetSumWays(int[] nums, int target){
        int sum=0;
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
        }
        int left=(target+sum)/2;
        if((target+sum)%2!=0)
            return 0;
        //接下来是计算容量为left的背包，装满有多少种方法。
        int[] dp = new int[left + 1];//dp[j]的含义是装满容量为j的背包有多少种方法。
        dp[0]=1;//初始化
        int n= nums.length;
        for(int i=0;i<n;i++){
            for(int j=left;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[left];
    }
}
