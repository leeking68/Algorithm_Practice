package leetcode;

public class Leet53 {
	
	public static void main(String args[]) {
		
		 int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		 System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;

		for (int idx = 0; idx < nums.length; idx++) {
			int sum = nums[idx];
			max = Math.max(max, sum);
			for (int idx2 = idx + 1; idx2 < nums.length; idx2++) {
				sum += nums[idx2];
				max = Math.max(max, sum);
			}
		}

		return max;
	}

}
