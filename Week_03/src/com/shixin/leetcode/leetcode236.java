package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/8/16/016.
 */
public class leetcode236 {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
     }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         //1.递归终止条件
        if(root==null || root==p || root==q){
            return root;
        }
        //2.进行递归调用
        TreeNode isLeft=lowestCommonAncestor(root.left,p,q);
        TreeNode isRight=lowestCommonAncestor(root.right,p,q);
        //此时说明p q分别存在于左右子树
        if(isLeft!=null && isRight!=null){
            return root;
        }else if(isLeft!=null){
            return isLeft;
        }else{
            return isRight;
        }
    }
}
