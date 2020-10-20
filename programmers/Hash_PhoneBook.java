package programmers;

import java.util.Arrays;

public class Hash_PhoneBook {
	
	public static void main(String[] args) {
		
	}
	
    public static boolean solution(String[] phone) {
        Arrays.sort(phone);

        String prefix = phone[0];
        
        for(int pos = 1; pos < phone.length; pos++) {
            
            String num = phone[pos];
            
            if(num.length() < prefix.length()||prefix.length() > num.length()) {
                continue;
            }
            
            //sol 1
            // String fixN = num.substring(0,prefix.length());
            // if(fixN.equals(prefix)) {
            //         return false;
            //     }
            
            
            //sol 2
            boolean fixN = num.startsWith(prefix);
           
               if(fixN) {
                    return false;
                }
                      
        }
           return true;
    }

}
