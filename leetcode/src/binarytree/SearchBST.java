package binarytree;

/**
 * @Author:zxp
 * @Description:给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * 示例 2:
 *
 *
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 * @Date:20:12 2023/12/26
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val){
        if(root==null)
            return root;
        if(root.val==val)
            return root;
        if(root.val>val)
            return searchBST(root.left,val);
        else
            return searchBST(root.right,val);
    }
}
