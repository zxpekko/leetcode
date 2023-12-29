package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:有 N
 *  种物品和一个容量是 V
 *  的背包。
 *
 * 第 i
 *  种物品最多有 si
 *  件，每件体积是 vi
 * ，价值是 wi
 * 。
 *
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V
 * ，用空格隔开，分别表示物品种数和背包容积。
 *
 * 接下来有 N
 *  行，每行三个整数 vi,wi,si
 * ，用空格隔开，分别表示第 i
 *  种物品的体积、价值和数量。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 * @Date:20:00 2023/6/15
 */
public class MorePack {
    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4};
        int[] w={2,4,4,5};
        int[] s={3,1,3,2};
        int i = MorePack.DynamicProgramming(v, w, s, 4, 5);
        System.out.println(i);
    }
    public static int DynamicProgramming(int[] v,int[] w,int[] s,int totalNumber,int totalVolumn){
        int[][] dp = new int[totalNumber+1][totalVolumn+1];
        for(int i=1;i<=totalNumber;i++){
            for(int j=1;j<=totalVolumn;j++){
                if(v[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else {
                    dp[i][j]=dp[i-1][j];
                    for(int k=0;k<=s[i-1] && k*v[i-1]<=j;k++){
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j-k*v[i-1]]+k*w[i-1]);
                    }
                }
            }
        }

        return dp[totalNumber][totalVolumn];
    }
}
