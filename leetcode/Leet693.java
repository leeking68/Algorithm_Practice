package leetcode;

public class Leet693 {
	   public static boolean hasAlternatingBits(int n) {
        
		   String bi = Integer.toBinaryString(n);
		   
		   for(int idx = 0; idx < bi.length()-1; idx++) {
			   System.out.println(idx);
			   String val1 = String.valueOf(bi.charAt(idx));
			   String val2 = String.valueOf(bi.charAt(idx+1));
			   
			   if(val1.equals(val2)) {
				   return false;
			   }
			   
		   }
		   return true;
		   
	    }
	   
	   public static void main(String[] args) {
		   int i  = 5;
		   String binaryString = Integer.toBinaryString(i);
		   System.out.println(binaryString);

		   System.out.println(hasAlternatingBits(5));
		   	
	   }
}
