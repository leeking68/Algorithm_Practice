package programmers;
/**
 * site : programmers
 * type(algo) : DFS
 * date : 2020 12-08
 * addr :https://programmers.co.kr/learn/courses/30/lessons/43162
 */
public class DFS_network_2 {

    public static void main(String[] args) {



    }

    public static int solution(int n,int[][] computers) {
        int res = 0;
        boolean[][] visited = new boolean[n][n];

        for(int c_idx = 0; c_idx < n; c_idx++)
            for(int r_idx = 0; r_idx < n; r_idx++) {
                if(!visited[c_idx][r_idx]&&computers[c_idx][r_idx]==1) {
                    res++;
                    visited[c_idx][r_idx] = true;
                    dfs(computers,visited,c_idx);
                }
            }
        return res;
    }

    public static void dfs(int[][] computers, boolean[][] visited, int start) {

        for (int col = 0; col < computers.length; col++) {
            if(!visited[start][col]&&computers[start][col]==1) {
                visited[start][col] = true;
                dfs(computers,visited,col);
            }
        }
    }
}
