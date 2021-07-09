package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @date : 2021-07-09
 * @author : Gilho Lee
 * solution : BFS
 * addr : https://leetcode.com/problems/open-the-lock/
 * difficulty : Medium
 */
public class leet752 {

    public static void main(String[] args ){

        String[] deads = {"0201","0101","0102","1212","2002"};
        System.out.println(openLock(deads,"0202"));

    }

    static int[][] dir = new int[][] {{1,0,0,0},{-1,0,0,0},{0,1,0,0},{0,-1,0,0},{0,0,1,0},{0,0,-1,0},{0,0,0,1},{0,0,0,-1}};
    public  static int openLock(String[] deadends, String target) {

        int count =0;

        HashSet<String> deadLock = new HashSet<String>();
        Queue<String> que = new LinkedList<String>();

        for(String deadNum : deadends)deadLock.add(deadNum);

        que.offer("0000"); //init

        while(!que.isEmpty()) {

            int size = que.size();
            for(int pos = 0; pos <size; pos++) {

                String curNum = que.poll();

                if(curNum.equals(target)) return count;
                if(deadLock.contains(curNum)) continue;

                deadLock.add(curNum);

                for(int idx = 0; idx <dir.length; idx++) {

                    //set next num
                    int[] next = new int[]{
                            curNum.charAt(0)-'0',
                            curNum.charAt(1)-'0',
                            curNum.charAt(2)-'0',
                            curNum.charAt(3)-'0',
                    };
                    System.out.println("### : " + next[0]+next[1]+next[2]+next[3]);

                    for(int k = 0; k < 4; k++) {
                        next[k] += dir[idx][k];
                        System.out.println("## : " + next[k]);
                        next[k] = next[k] > 9 ? 0 : next[k];
                        next[k] = next[k] < 0 ? 9 : next[k];
                    }
                    String nextNum ="" + next[0]+next[1]+next[2]+next[3];
                    if(!deadLock.contains(nextNum)) que.offer(nextNum);

                }

            }
            count++;
        }

        return -1;
    }
}
