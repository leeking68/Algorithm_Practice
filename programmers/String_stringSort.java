package programmers;

import java.util.*;
public class String_stringSort {

	/**
	 * Problem from : Programmers
	 * 
	 * @author Gil email : leeeeeegilho@gmail.com
	 *
	 *         URI : https://programmers.co.kr/learn/courses/30/lessons/12915
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		String[] str = {"bed", "sun", "car"};
	
		
	}
	
    public static String[] solution(String[] strings, int n) {
    
        
        Arrays.sort(strings, new Comparator<String>(){
            
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1 :" + o1 + " o2 : " + o2);
                if(o1.charAt(n) > o2.charAt(n)) {
                return 1;
                } else if(o1.charAt(n)==o2.charAt(n)) {
                    return o1.compareTo(o2);
                    
                } else return -1;
                
            }
            
        });
        
        return strings;
    }
	
}
