package acmicpc;

/**
 * Problem from : baekjoon

 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://www.acmicpc.net/problem/15686
 *         
 * 
 * 
 */

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
 
public class DFS_15686 {
	
    static LinkedList<Point> chiken = new LinkedList<>();
    static LinkedList<Point> home = new LinkedList<>();
    static int map[][];
    static int ans = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader rc = new BufferedReader(new InputStreamReader(System.in));
         
        String str = rc.readLine();
        String[] strArr =str.split(" ");
         
        int N =Integer.parseInt(strArr[0]);
        int M =Integer.parseInt(strArr[1]);
         
        map = new int[N][N];
        for(int i=0; i<map.length; i++){
            String str1 = rc.readLine();
            String strArr1[] = str1.split(" ");
            for(int j=0; j<map[0].length; j++){
                map[i][j] = Integer.parseInt(strArr1[j]);
                if(map[i][j]==2) chiken.add(new Point(i,j)); 
                if(map[i][j]==1) home.add(new Point(i, j)); 
            }
        }
         
        //치킨집 선택 순열
        int comArr[] = new int[M];
        DFS(chiken.size(), comArr, M, 0, 0);
         
        System.out.println(ans);
 
     
    }
    private static void DFS(int size, int[] comArr, int r, int index, int target) {
        if(r == 0){
            //comArr 치킨집 뽑은 경우의 수 순열
            int ansTmp = 0;
            for(int i=0; i<home.size(); i++){
                Point h = home.get(i);
                int distance = 1000000;
                for(int j=0; j<comArr.length; j++){
                    Point c = chiken.get(comArr[j]);
                    int gap = Math.abs(h.x-c.x)+Math.abs(h.y-c.y);
                    if(distance > gap){
                        distance = gap;
                    }
                }
                ansTmp += distance;
            }
            if(ans > ansTmp){
                ans = ansTmp;
            }
            return;
        }else if(target == size){
            return;
        }else{
            comArr[index] = target;
            DFS(size, comArr, r-1, index+1, target+1);
            DFS(size, comArr, r, index, target+1);
        }
         
         
    }
}