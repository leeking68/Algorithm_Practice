package programmers;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI : https://programmers.co.kr/learn/courses/30/lessons/42747
 * 
 * 
 * 
 */
public class Sort_H_index {

	public int solution(int[] citations) {
		int len = citations.length;
		int h = 0;
		for (int idx = 0; idx < len; idx++) {
			int hValue = citations[idx];
			int cnt = 0;
			boolean flag = true;
			for (int idx2 = 0; idx2 < len; idx2++) {

				if (citations[idx2] >= hValue) {

					cnt++;

					if (cnt > hValue) {
						flag = false;
						break;
					}

				}
			}

			if (flag) {
				if (cnt > h) {
					h = cnt;
				}
			}

		}

		return h;
	}
}
