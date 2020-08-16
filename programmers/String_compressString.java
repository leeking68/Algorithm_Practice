package programmers;

public class String_compressString {

	public static void main(String args[]) {

		String s= "abcd";
		System.out.println(solution(s));
		
	}

	public static int solution(String s) {
		int answer = 0;
		
		int divNum = (s.length())/2;
		String str ="";
		String[] arr = s.split("");
		
		for(int idx = 0; idx < arr.length; idx++) {
			System.out.println(arr[idx]);
		}
		
		for(int div = divNum; div > 0; div--) {
			
		}
		
		return answer;

	}

}
