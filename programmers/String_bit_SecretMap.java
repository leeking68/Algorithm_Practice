package programmers;
/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://programmers.co.kr/learn/courses/30/lessons/17681
 *         
 *      
 * 
 */

public class String_bit_SecretMap {

	public static void main(String[] args) {
		int n = 5; 
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] ans = solution(n,arr1,arr2);
		
		for(int idx = 0; idx < n; idx++) {
			System.out.println(ans[idx]);
		}
	}
	// before test, have to delete 'static' keywords

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int idx = 0; idx < n; idx++) {
			String arr1Str = numtoBi(n, arr1[idx]);
			String arr2Str = numtoBi(n, arr2[idx]);
			answer[idx] = compareNum(arr1Str, arr2Str);
		}

		return answer;
	}

	public static String numtoBi(int n, int num) {

		String biStr = Integer.toBinaryString(num);

		if (biStr.length() < n) {
			String preZero = "";
			int addZeroSize = (n - biStr.length());

			for (int idx = 0; idx < addZeroSize; idx++) {
				preZero += "0";
			}

			biStr = (preZero + biStr);

			return biStr;

		}

		return biStr;
	}

	public static String compareNum(String str1, String str2) {

		String mapNum = "";
		System.out.println("str1 : " + str1+" str2 : " + str2);
		for (int idx = 0; idx < str1.length(); idx++) {

			if ((str1.charAt(idx)!='1')&& (str2.charAt(idx)!='1')) {
				mapNum += " ";
			} else {
				mapNum += "#";
			}

		}
		System.out.println(mapNum);

		return mapNum;

	}

}
