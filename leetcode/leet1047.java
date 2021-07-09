package leetcode;

import java.util.ArrayList;

public class leet1047 {

	public static void main(String[] args) {

		removeDuplicates("abbaca");
		System.out.println(removeDuplicates2("aaaaaaaa") + ":");

	}

	public static String removeDuplicates(String S) {

		int cnt = 0, idx = 0, size = S.length();
		String[] copyStr;

		ArrayList<String> list;
		char[] chS = S.toCharArray();

		while (true) {

			boolean check = true;
			list = new ArrayList<>();
			idx = 0;

			if (chS[idx] == chS[idx + 1]) {
				idx += 2;
			} else {
				list.add(Character.toString(chS[idx]));
				idx++;
			}

			if (check) {

				break;
			}

		}

		String ans = "s";

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		return ans;

	}

	public static String removeDuplicates2(String S) {
		if (S == null || S.length() == 0) {
			return S;
		}

//		boolean check = true;
//		char[] ch = S.toCharArray();
//
//		for (int i = 1; i < S.length() - 1; i++) {
//
//			if (ch[0] != ch[i]) {
//				check = false;
//				break;
//			}
//
//		}
//
//		if (check) {
//			return Character.toString(ch[0]);
//		}

		boolean check = true;
		int count = 0;

		while (check) {
			check = false;
			StringBuilder sb = new StringBuilder();

			int i = 0;
			while (i < S.length()) {
				if (i == S.length() - 1 || S.charAt(i) != S.charAt(i + 1)) {
					sb.append(S.charAt(i));
					i++;
				} else {
					check = true;
					int j = i + 1;
					count = 1;
					while (j < S.length() && S.charAt(i) == S.charAt(j) && count < 2) {
						j++;
						count++;
					}

					i = j;
				}
			}

			S = sb.toString();
		}

		return S;
	}

}
