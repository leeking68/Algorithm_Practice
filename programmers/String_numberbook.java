package programmers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * site : programmers
 * type(algo) : String
 * date : 2020 12-06
 * addr : https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class String_numberbook {

    public static void main (String args[]) {

        Scanner in = new Scanner(System.in);

        String[] books = {"010111","010"};
        System.out.println(solution(books));

    }

    public static boolean solution(String[] books) {

        for(int pos = 0; pos < books.length; pos++) {

            String prefix = books[pos];


            for(int idx = 0; idx < books.length; idx++) {

                if(pos == idx) {
                    continue;
                }
                String compareNum = books[idx];

                if(prefix.length() > compareNum.length()) {
                    continue;
                }

                //sol 1
                if(prefix.equals(compareNum.substring(0,prefix.length()))) {
                    return false;
                }

                //sol2
                if(compareNum.startsWith(prefix)) {
                    return false;
                }

            }

        }

        return true;
    }
}
