package programmers;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI : https://programmers.co.kr/learn/courses/30/lessons/17677
 *         
 * 
 */
public class MergeSort_Newsclustering {

	public static void main(String[] args) {

		System.out.println(solution("FRANCE", "french"));
	}
	// before test, have to delete 'static' keywords
	public static int solution(String str1, String str2) {
		int answer = 0;
		double jakardNum = 0;
		ArrayList<String> strList1 = new ArrayList<String>();
		ArrayList<String> strList2 = new ArrayList<String>();
		ArrayList<String> interList = new ArrayList<String>();
		ArrayList<String> uniList = new ArrayList<String>();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		for(int index = 0; index < str1.length()-1; index++) {
			char ch1 = str1.charAt(index);
			char ch2 = str1.charAt(index+1);
			if(checkArrange(ch1, ch2)) {
				strList1.add(ch1+""+ch2);
			}
		}
		for(int index = 0; index < str2.length()-1; index++) {
			char ch1 = str2.charAt(index);
			char ch2 = str2.charAt(index+1);
			if(checkArrange(ch1, ch2)) {
				strList2.add(ch1+""+ch2);
			}
		}
		
		Collections.sort(strList1);
		Collections.sort(strList2);

		for(String word : strList1) {
			if(strList2.remove(word)) {
				interList.add(word);
			}
			uniList.add(word);
		}
		for(String word : strList2) {
			uniList.add(word);
		}
		
		if(uniList.size() == 0) {
			jakardNum = 1;
		} else {
			jakardNum = (double)interList.size()/(double)uniList.size();
		}
		answer = (int)(jakardNum*65536);
		
		
		return answer;
	}
	
	public static boolean checkArrange(char str1First, char str1Second) {
		
		return (str1First <= 'z') && (str1First >= 'a')&&(str1Second <= 'z') && (str1Second >= 'a');
	}

}
