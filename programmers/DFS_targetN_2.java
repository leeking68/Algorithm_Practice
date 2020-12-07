package programmers;
/**
 * site : programmers
 * type(algo) : DFS
 * date : 2020 12-07
 * addr : https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class DFS_targetN {

    public static int cnt = 0;
    public static void main(String[] args) {

        int numbers[] = {1,1,1,1,1};
        System.out.println(solution(numbers,3));


    }

    public static int solution(int[] numbers, int target) {

        int ans = 0 ;

        dfs(numbers,target,1,-(numbers[0]));
        dfs(numbers,target,1,numbers[0]);

        ans = cnt;
        return ans;

    }

    public static void dfs(int[] numbers, int target, int index, int result) {

        if(numbers.length == index) {
            if(result == target) cnt++;
            return;
        }
        dfs(numbers,target,index+1,result+numbers[index]);
        dfs(numbers,target,index+1,result-numbers[index]);


    }

}
