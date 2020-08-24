package com.shixin.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2020/8/23/023.
 */
public class leetcode874 {
    public int robotSim(int[] commands,int[][] obstacles){
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        Set<String> obstaclesSet=new HashSet<>();
        for(int[] obstacle:obstacles){
            obstaclesSet.add(obstacle[0]+","+obstacle[1]);
        }

        int result=0;
        int di=0;
        int x=0;
        int y=0;
        for(int command:commands){
            if (command == -2){
                di = (di + 3) % 4;
            }else if (command == -1){
                di = (di + 1) % 4;
            }else{
                for(int i=0;i<command;i++){
                    int nx=x+dx[di];
                    int ny=y+dy[di];
                    if(obstaclesSet.contains(nx+","+ny)){
                        break;
                    }else{
                        x=nx;
                        y=ny;
                        result=Math.max(result,x*x+y*y);
                    }
                }
            }
        }
        return result;
    }
}

