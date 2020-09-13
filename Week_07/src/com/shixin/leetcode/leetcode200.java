package com.shixin.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2020/9/13/013.
 */
public class leetcode200 {
//    public void dfs(char[][] grid,boolean[][] visited,int i,int j,int rowlength,int collength){
//        visited[i][j]=true;
//        if(i+1<rowlength && !visited[i+1][j] && grid[i+1][j]=='1'){
//            dfs(grid,visited,i+1,j,rowlength,collength);
//        }
//        if(i-1>=0 && !visited[i-1][j] && grid[i-1][j]=='1'){
//            dfs(grid,visited,i-1,j,rowlength,collength);
//        }
//        if(j+1<collength && !visited[i][j+1] && grid[i][j+1]=='1'){
//            dfs(grid,visited,i,j+1,rowlength,collength);
//        }
//        if(j-1>=0 && !visited[i][j-1] && grid[i][j+-1]=='1'){
//            dfs(grid,visited,i,j-1,rowlength,collength);
//        }
//    }
//    public int numIslands(char[][] grid) {
//        int rowlength=grid.length;
//        if (rowlength == 0) {
//            return 0;
//        }
//        int collength=grid[0].length;
//        int result=0;
//        boolean[][] visited=new boolean[rowlength][collength];
//        for(int i=0;i<rowlength;i++){
//            for(int j=0;j<collength;j++){
//                if(grid[i][j]=='1' && !visited[i][j]){
//                    result++;
//                    dfs(grid,visited,i,j,grid.length,grid[i].length);
//                }
//            }
//        }
//        return  result;
//    }

//    public void bfs(char[][] grid, boolean[][] visited,int rowlength, int collength, Queue<Integer> queue){
//        while(!queue.isEmpty()){
//            int index=queue.poll();
//            int rowIndex=index/collength;
//            int colIndex=index%collength;
//            if(rowIndex+1<rowlength && !visited[rowIndex+1][colIndex] && grid[rowIndex+1][colIndex]=='1'){
//                queue.add((rowIndex+1)*collength+colIndex);
//                visited[rowIndex+1][colIndex]=true;
//            }
//            if(rowIndex-1>=0 && !visited[rowIndex-1][colIndex] && grid[rowIndex-1][colIndex]=='1'){
//                queue.add((rowIndex-1)*collength+colIndex);
//                visited[rowIndex-1][colIndex]=true;
//            }
//            if(colIndex+1<collength && !visited[rowIndex][colIndex+1] && grid[rowIndex][colIndex+1]=='1'){
//                queue.add(rowIndex*collength+colIndex+1);
//                visited[rowIndex][colIndex+1]=true;
//            }
//            if(colIndex-1>=0 && !visited[rowIndex][colIndex-1] && grid[rowIndex][colIndex-1]=='1'){
//                queue.add(rowIndex*collength+colIndex-1);
//                visited[rowIndex][colIndex-1]=true;
//            }
//        }
//    }
//
//
//    public int numIslands(char[][] grid) {
//        int rowlength=grid.length;
//        if (rowlength == 0) {
//            return 0;
//        }
//        int collength=grid[0].length;
//        int result=0;
//        boolean[][] visited=new boolean[rowlength][collength];
//        Queue<Integer> queue=new LinkedList<>();
//        for(int i=0;i<rowlength;i++){
//            for(int j=0;j<collength;j++){
//                if(grid[i][j]=='1' && !visited[i][j]){
//                    queue.add(i*collength+j);
//                    result++;
//                    bfs(grid,visited,grid.length,grid[i].length,queue);
//                }
//            }
//        }
//        return  result;
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


    public int numIslands(char[][] grid) {
        int rowlength=grid.length;
        if (rowlength == 0) {
            return 0;
        }
        int collength=grid[0].length;
        UF uf=new UF(collength*rowlength+1);
        for(int i=0;i<rowlength;i++){
            for(int j=0;j<collength;j++){
                if(grid[i][j]=='1'){
                    if(i+1<rowlength && grid[i+1][j]=='1'){
                        uf.union(i*collength+j,(i+1)*collength+j);
                    }
                    if(j+1<collength && grid[i][j+1]=='1'){
                        uf.union(i*collength+j,i*collength+j+1);
                    }
                }else{
                    uf.union(i*collength+j,rowlength*collength);
                }
            }
        }
        return  uf.getCount()-1;
    }

    public static void main(String[] args) {
        char[][] grid=new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        new leetcode200().numIslands(grid);
    }
}
