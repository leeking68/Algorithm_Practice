package leetcode;
/**
 * @date : 2021-07-19
 * @author : Gilho Lee
 * solution : Simulation
 * addr : https://leetcode.com/problems/find-the-town-judge/submissions/
 * difficulty : Easy
 */
import java.util.HashSet;

public class Leet997 {

    public static void main(String[] args) {

        Leet997 leet997 = new Leet997();

        int[][] trust = {{1,2}};
//        int[][] trust = {{1,3},{2,3}};
        System.out.println(leet997.findJudge(2,trust));

    }

    public int findJudge(int n, int[][] trust) {

        int[] cnt = new int[1001];
        HashSet<Integer> set = new HashSet<>();

        if(n == 1 && trust.length == 0) return 1;

        for (int i = 0; i < trust.length; i++){
            cnt[trust[i][1]]++;
            set.add(trust[i][0]);
        }

        for(int i = 0; i < 1001; i++) {
//            if(cnt[trust[i][1]]==(n-1) && (!set.contains(trust[i][1]))) return trust[i][1];
            System.out.println("cnt[i] : " + cnt[i]);
            System.out.println("key " + set.contains(i));
            if(cnt[i]==(n-1) && (!set.contains(i))) return i;

        }

        return  -1;
    }
}

