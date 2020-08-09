package com.shixin.leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2020/8/8/008.
 */
public class leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !stack.empty()){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            result.add(curr.val);
            if(curr!=null){
                curr=curr.right;
            }
        }
        return result;


        //1.迭代
        //inorderOperation(root,result);
//        return result;
    }
    public void inorderOperation(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        inorderOperation(root.left,result);
        result.add(root.val);
        inorderOperation(root.right,result);
     }
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }

    }
}
