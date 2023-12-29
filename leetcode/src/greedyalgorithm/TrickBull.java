package greedyalgorithm;

/**
 * @Author:zxp
 * @Description:农民约翰的 N
 *  头奶牛（编号为 1..N
 * ）计划逃跑并加入马戏团，为此它们决定练习表演杂技。
 *
 * 奶牛们不是非常有创意，只提出了一个杂技表演：
 *
 * 叠罗汉，表演时，奶牛们站在彼此的身上，形成一个高高的垂直堆叠。
 *
 * 奶牛们正在试图找到自己在这个堆叠中应该所处的位置顺序。
 *
 * 这 N
 *  头奶牛中的每一头都有着自己的重量 Wi
 *  以及自己的强壮程度 Si
 * 。
 *
 * 一头牛支撑不住的可能性取决于它头上所有牛的总重量（不包括它自己）减去它的身体强壮程度的值，现在称该数值为风险值，风险值越大，这只牛撑不住的可能性越高。
 *
 * 您的任务是确定奶牛的排序，使得所有奶牛的风险值中的最大值尽可能的小。
 *
 * 输入格式
 * 第一行输入整数 N
 * ，表示奶牛数量。
 *
 * 接下来 N
 *  行，每行输入两个整数，表示牛的重量和强壮程度，第 i
 *  行表示第 i
 *  头牛的重量 Wi
 *  以及它的强壮程度 Si
 * 。
 *
 * 输出格式
 * 输出一个整数，表示最大风险值的最小可能值。
 *
 * 数据范围
 * 1≤N≤50000
 * ,
 * 1≤Wi≤10,000
 * ,
 * 1≤Si≤1,000,000,000
 * 输入样例：
 * 3
 * 10 3
 * 2 5
 * 3 3
 * 输出样例：
 * 2
 * @Date:11:35 2023/8/15
 */
public class TrickBull {
    public static void main(String[] args) {
        int[][] weightAndStrength={{10,3},{2,5},{3,3}};
        TrickBull trickBull = new TrickBull();
        int greedy = trickBull.Greedy(weightAndStrength);
        System.out.println(greedy);
    }
    public int Greedy(int[][] weightAndStrenth){
        for(int i=0;i< weightAndStrenth.length-1;i++){
            for(int j=0;j< weightAndStrenth.length-1-i;j++){
                if(weightAndStrenth[j][0]+weightAndStrenth[j][1]>weightAndStrenth[j+1][0]+weightAndStrenth[j+1][1]){
                    int[] temp=new int[2];
                    temp=weightAndStrenth[j];
                    weightAndStrenth[j]=weightAndStrenth[j+1];
                    weightAndStrenth[j+1]=temp;
                }
            }
        }
        int maxDangerVal=-1000000;
        for(int i=1;i<weightAndStrenth.length;i++){
            int totalWeight=0;
            for(int j=0;j<i;j++){
                totalWeight+=weightAndStrenth[j][0];
            }
            if(totalWeight-weightAndStrenth[i][1]>maxDangerVal)
                maxDangerVal=totalWeight-weightAndStrenth[i][1];
        }

        return maxDangerVal;
    }

}
