package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet169 {

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maj = nums.length/2;
        int ans = 0;
        for(int number : nums) {

            if(map.containsKey(number)) {
                int cnt = map.get(number);
                map.put(number,cnt+1);
            } else {

                map.put(number,1);

            }

        }

        for(Map.Entry<Integer, Integer> ety : map.entrySet()) {
            if(ety.getValue() > maj) {
                ans = ety.getKey();

            }
        }

        return ans;

    }
}
