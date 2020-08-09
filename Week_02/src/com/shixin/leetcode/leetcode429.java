package com.shixin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/8/9/009.
 */
public class leetcode429 {

    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            List<Integer> level=new ArrayList<>();
            //size要提取出来
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                level.add(node.val);
                if(node.children!=null){
                   queue.addAll(node.children);
                }
            }
            result.add(level);
        }
        return result;
    }

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
}
