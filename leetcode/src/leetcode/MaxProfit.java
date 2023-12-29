package leetcode;

/**
 * @Author:zxp
 * @Description:给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @Date:11:01 2023/8/24
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        int i = maxProfit.maxProfit(prices);
        System.out.println(i);
    }
//    public int maxProfit(int[] prices){
//        if(prices.length==0)
//            return 0;
////        int flag=0;
////        for(int i=0;i<prices.length-1;i++){
////            if(prices[i])
////        }
//        int[] profits=new int[prices.length];
//        for(int i=0;i<prices.length-1;i++){
//            for(int j=i+1;j<prices.length;j++){
//                if(prices[j]-prices[i]>profits[i])
//                    profits[i]=prices[j]-prices[i];
//            }
//        }
//        int max=-10001;
//        for(int i=0;i<profits.length;i++){
//            if(profits[i]>max)
//                max=profits[i];
//        }
//        return max;
//    }
    public int maxProfit(int[] prices){
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice)
                minPrice=prices[i];
            else if(prices[i]-minPrice>maxProfit)
                maxProfit=prices[i]-minPrice;
        }
        return maxProfit;
    }
}
