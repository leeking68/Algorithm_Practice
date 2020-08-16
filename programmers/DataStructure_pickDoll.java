package programmers;

/**
 * Problem from : Programmers
 * 
 * @author Gil email : leeeeeegilho@gmail.com
 *
 *         URI :
 *         https://programmers.co.kr/learn/courses/30/lessons/64061
 *         
 *         Solution : using ArrayList
 *         Solution : using Stack
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Stack;

public class DataStructure_pickDoll {

	public static void main(String[] args) {

		
	}
	// before test, have to delete 'static' keywords
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		ArrayList<Integer> box = new ArrayList<Integer>();

		for (int idx = 0; idx < moves.length; idx++) {

			int row = moves[idx] - 1;

			for (int col = 0; col < board.length; col++) {

				int boxLastIdx = box.size() - 1;

				if (board[col][row] != 0) {

					if (box.isEmpty()) {
						box.add(board[col][row]);
					} else {

						if (box.get(boxLastIdx) == board[col][row]) {

							box.remove(boxLastIdx);
							answer += 2;
						} else {
							box.add(board[col][row]);
						}

					}
					board[col][row] = 0;

					break;

				}

			}

		}

		return answer;
	}
	

    public int solution2(int[][] board, int[] moves) {
		Stack<Integer> box = new Stack<Integer>();

		int answer = 0;
		for (int i = 0; i < moves.length; i++) {
			int row = moves[i];
			for (int col = 0; col < board.length; col++) {
				if (board[col][row - 1] != 0) {

					if (box.empty()) {
						box.push(board[col][row-1]);
					} else {

						if (box.peek() == board[col][row-1]) {
							box.pop();
							answer += 2;
						} else {

							box.push(board[col][row-1]);
						}

					}
					board[col][row-1] = 0;

					break;
				}

			}

		}

		return answer;
    }
}
