package com.shixin.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2020/8/8/008.
 */
public class leetcode589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> result=new ArrayList<>();
            if(root==null){
                return result;
            }
            Stack<Node> stack=new Stack<Node>();
            stack.push(root);
            while(!stack.empty()){
                Node node=stack.pop();
                result.add(node.val);
                List<Node> children=node.children;
                if(children!=null){
                    Collections.reverse(children);
                    for(Node child:children){
                        stack.push(child);
                    }
                }
            }

//            preOperation(root,result);
            return result;
        }
//        public void preOperation(Node root,List<Integer> result){
//            List<Node> children=root.children;
//            result.add(root.val);
//            if(children==null){
//                return;
//            }else{
//                for(Node child:children){
//                    preOperation(child,result);
//                }
//            }
//        }
    }
}
