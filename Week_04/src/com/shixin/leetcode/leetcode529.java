package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/8/23/023.
 */
public class leetcode529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x=click[0];
        int y=click[1];
        if(board[x][y]=='M'){
            board[x][y]='X';
            return board;
        }
        dfs(board,x,y);
        return board;
    }
    public void dfs(char[][] board,int x,int y){
        int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};
        int rangeBoom=0;
        for(int i=0;i<dirX.length;i++){
            int tx=x+dirX[i];
            int ty=y+dirY[i];
            if(tx<0 || ty<0 || tx>=board.length || ty>=board[0].length){
                continue;
            }
            if(board[tx][ty]=='M'){
                rangeBoom++;
            }
        }
        if(rangeBoom>0){
            board[x][y]= (char) ('0'+rangeBoom);
        }else{
            board[x][y]='B';
            for(int i=0;i<dirX.length;i++){
                int tx=x+dirX[i];
                int ty=y+dirY[i];
                if(tx<0 || ty<0 || tx>=board.length || ty>=board[0].length || board[tx][ty]!='E'){
                    continue;
                }
                dfs(board,tx,ty);
            }
        }


    }

}
