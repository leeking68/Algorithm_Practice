package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
//https://programmers.co.kr/learn/courses/30/lessons/12899?language=java
public class Default_124number {

	public static void main(String args[]) {
		System.out.println(solution(3));

	}

	public static String solution(int n) {

		String answer = "";

		int mod;

		while (n > 0) {

			mod = n % 3;
			n /= 3;

			if (mod == 0) {
				n -= 1;
				mod = 4;
			}

			answer += String.valueOf(mod);

		}

		return answer;

	}

}
