package programmers;

/**
 * site : programmers
 * type(algo) : DFS
 * date : 2020 12-09
 * addr : https://programmers.co.kr/learn/courses/30/lessons/43164
 */
public class DFS_tripRoute {

    public static String[] ans = null;

    public static void main(String[] args) {

        String[][] ticket = {{"ICN","JFK"},{"HDN","IAD"},{"JFK","HDN"}};
        System.out.println(solution(ticket));
    }
    public static String[] solution(String[][] tickets) {
    ans = new String[tickets.length+1];
    boolean[] visited = new boolean[tickets.length];

    for(int idx =0; idx < tickets.length; idx++) {

        if("ICN".equals(tickets[idx][0])&&!visited[idx]) {
            System.out.println("GO : "+tickets[idx][1]);
            visited[idx] = true;
            dfs(visited,tickets,tickets[idx][1],"ICN"+","+tickets[idx][1],1);
            visited[idx] = false;

        }

    }
        return ans;
    }

    public static void dfs(boolean[] visited, String[][] tickets,String start, String way, int depth) {
        System.out.println(depth+ " : " + start);
        if(depth == tickets.length) {
            System.out.println(way);
            String[] ways = way.split(",");

            if(ans[0]==null) {

             ans = ways;

            } else {

            ans = compareWays(ans,ways);

            }
            return;
        }

        for(int idx =0; idx < tickets.length; idx++) {

            if(start.equals(tickets[idx][0])&&!visited[idx]) {

                visited[idx] = true;
                dfs(visited,tickets,tickets[idx][1],way+","+tickets[idx][1],depth+1);
                visited[idx] = false;

            }

        }

    }

    public static String[] compareWays(String[] old_w, String[] new_w) {

        boolean flag = true;

        for(int idx = 0; idx < old_w.length; idx++) {

            if(old_w[idx]!=new_w[idx]) {

                char[] oW = old_w[idx].toCharArray();
                char[] nW = new_w[idx].toCharArray();


                for(int idx2= 0; idx2 < 3; idx2++) {

                    if(oW[idx2] < nW[idx2]) {
                        return old_w;
                    } else if (oW[idx2] > nW[idx2]){
                        return new_w;
                    }

                }
            }


        }

        return old_w;

    }

    }
