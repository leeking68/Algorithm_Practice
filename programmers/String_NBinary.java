package programmers;
/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://programmers.co.kr/learn/courses/30/lessons/42579]
 *         ref : https://javaplant.tistory.com/10
 * 
 * 
 */
public class String_NBinary {

	public static void main(String args[]) {

		System.out.println("##: " + solution(2, 4, 1, 1));

	}
	// before test, have to delete 'static' keywords
	public static String solution(int n, int t, int m, int p) {
		String answer = "";
		String biWord = "";
		int turnNum = 0;
		boolean flag = false;
		for (int bi_idx = 0; bi_idx <= 1000; bi_idx++) {

			biWord = conversion(n, bi_idx);
			for (char cWord : biWord.toCharArray()) {
				turnNum++;
				if (turnNum == p) {
					answer += cWord;
					if (answer.length() == t) {
						flag = true;
						break;
					}
				}

				if (turnNum == m) {
					turnNum = 0;
				}
			}
			if (flag) {
				break;
			}
		}

		return answer;
	}

	public static String conversion(int n, int num) {
		String retVal = "";
		if (num == 0)
			retVal = "0";
		while (num != 0) {
			retVal = (num % n < 10 ? Integer.toString(num % n) : Character.toString((char) (num % n + 55))) + retVal;
			if (num / n == 0)
				retVal = num + retVal;
			num = num / n;
		}
		return retVal;
	}

}
