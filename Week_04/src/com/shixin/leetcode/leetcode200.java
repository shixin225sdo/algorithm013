package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/8/23/023.
 */
public class leetcode200 {
    public int numIslands(char[][] grid) {
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    result++;
                    paddingZero(grid,i,j,grid.length,grid[i].length);
                }
            }
        }
        return  result;
    }
    public void paddingZero(char[][] grid,int i,int j,int iLength,int jLength){
        if(grid[i][j]=='0'){
            return;
        }else{
            grid[i][j]='0';
            if(i+1<iLength){
                paddingZero(grid,i+1,j,iLength,jLength);
            }
            if(i-1>=0){
                paddingZero(grid,i-1,j,iLength,jLength);
            }
            if(j+1<jLength){
                paddingZero(grid,i,j+1,iLength,jLength);
            }
            if(j-1>=0){
                paddingZero(grid,i,j-1,iLength,jLength);
            }

        }
    }
}
