package com.shixin.leetcode;

import java.util.LinkedList;

/**
 * Created by Administrator on 2020/9/13/013.
 */
public class leetcode547 {
//    public void dfs(int colLength,int[][] M,int i,boolean[] visited){
//        for(int j=0;j<colLength;j++){
//            if(!visited[j] && M[i][j]==1){
//                visited[j]=true;
//                dfs(colLength,M,j,visited);
//            }
//        }
//    }
//    public int findCircleNum(int[][] M) {
//        int rowLength=M.length;
//        int colLength=M[0].length;
//        int result=0;
//        boolean[] visited=new boolean[rowLength];
//        for(int i=0;i<rowLength;i++){
//            if(!visited[i]){
//                dfs(colLength,M,i,visited);
//                result++;
//            }
//
//        }
//        return result;
//    }

//    public void bfs(LinkedList<Integer> queue,int colLength,int[][] M,boolean[] visited){
//        while(!queue.isEmpty()){
//            int index=queue.remove();
//            visited[index]=true;
//            for(int j=0;j<colLength;j++){
//                if(M[index][j]==1 && !visited[j]){
//                    queue.add(j);
//                }
//            }
//        }
//    }
//    public int findCircleNum(int[][] M) {
//        int rowLength=M.length;
//        int colLength=M[0].length;
//        int result=0;
//        boolean[] visited=new boolean[rowLength];
//        LinkedList<Integer> queue=new LinkedList<>();
//        for(int i=0;i<rowLength;i++){
//            if(!visited[i]){
//                queue.add(i);
//                bfs(queue,colLength,M,visited);
//                result++;
//            }
//
//        }
//        return result;
//    }

    class UF{
        int count;
        int[] parent;
        int[] size;

        public UF(int n){
            this.count=n;
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        public int find(int findIndex){
            while(parent[findIndex]!=findIndex){
                parent[findIndex]=parent[parent[findIndex]];
                findIndex=parent[findIndex];
            }
            return findIndex;
        }
        public void union(int firstIndex,int secondIndex){
            int rootFirst=find(firstIndex);
            int rootSecond=find(secondIndex);
            if(rootFirst==rootSecond){
                return;
            }else{
                if(size[rootFirst]>=size[secondIndex]){
                    parent[rootSecond]=rootFirst;
                    size[rootFirst]+= size[rootSecond];
                }else{
                    parent[rootFirst]=rootSecond;
                    size[rootSecond]+= size[rootFirst];
                }
                count--;
            }
        }
        public int getCount(){
            return count;
        }
    }
    public int findCircleNum(int[][] M) {
        UF uf = new UF( M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }

        return uf.getCount();

    }
}
