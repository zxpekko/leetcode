package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * @Date:17:08 2023/12/16
 */
public class CountSubstrings {
    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings("aaa"));
    }
    public int countSubstrings(String s){
        int n=s.length();
        boolean[][] dp = new boolean[n][n];//dp[i][j]表示i到j的下标的子串是否是回文字符串。
        int result=0;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        dp[i][j]=true;
                        result++;
                    }
                    else if(dp[i + 1][j - 1]){
                        dp[i][j]=true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
