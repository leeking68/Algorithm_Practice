package leetcode;

public class Leet209 {
	
		public static void main(String[] args) {
			
			int t = 7;
			int[] nums = {2,3,1,2,4,3};
			
			System.out.println(minSubArrayLen(t, nums));
		}
	
	   public static int minSubArrayLen2(int target, int[] nums) {
	        int ans = Integer.MAX_VALUE;
	        
	        int sum = 0;
	        for(int idx : nums) {
	        	sum+=idx;
	        }
	        
	        if (sum < target) return 0;
	        
	        sum = 0;
	        
	        for(int idx = 0; idx < nums.length; idx++) {
	        	
	        	sum = nums[idx];
	        	int count = 1;
	        	if(sum == target) return count;
	        	
	        	for(int idx2= idx+1; idx2 < nums.length; idx2++) {
	        		
	        		count++;
	        		sum += nums[idx2];
	        		System.out.println(idx + " : " + idx2 + " sum : " + sum);
	        		if(sum == target) {
	        			if(ans > count) {
	        				ans = count;
	        			}
	        		}
	        		
	        		
	        	}
	        	count = 0;
	        }
	        
	        return ans;
	    }
	   public static int minSubArrayLen(int target, int[] nums) {
	        int ans = Integer.MAX_VALUE;
	        
	        int sum = 0;
	        for(int idx : nums) {
	        	sum+=idx;
	        }
	        
	        if (sum < target) return 0;
	        sum = 0;
	        
	        
	        
	        
	        return ans;
	    }
}
