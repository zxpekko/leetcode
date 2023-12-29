package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 *
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 *
 *
 * 提示：
 *
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 * @Date:13:23 2023/12/26
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        TreeNode construct = construct(root1, root2);
        return construct;
    }
    public TreeNode construct(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return null;
        TreeNode root=new TreeNode();
        if(root1!=null&&root2==null){
            root.val= root1.val;
            root.left=construct(root1.left,null);//为了体现一致性，向下遍历，这边使用null传参。
            root.right=construct(root1.right,null);
        }

//            return root1;
        if(root1==null&&root2!=null){
            root.val= root2.val;
            root.left=construct(null,root2.left);
            root.right=construct(null,root2.right);
        }

//            return root2;
        else if(root1!=null&&root2!=null){
            root.val= root1.val+root2.val;
            root.left=construct(root1.left,root2.left);
            root.right=construct(root1.right,root2.right);
        }
        return root;
    }
}