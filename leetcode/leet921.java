package leetcode;

import java.util.Stack;

public class leet921 {

	public int minAddToMakeValid(String S) {

		if (S.length() == 0)
			return 0;
		if (S.length() == 1)
			return 1;

		Stack<Character> st = new Stack();

		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);

			if (ch == '(') {
				st.push(ch);
			} else if (st.empty()) {
				st.push(ch);
			} else if ('(' == st.peek()) {
				st.pop();
			} else {
				st.push(ch);
			}

		}

		return st.size();
	}
}
