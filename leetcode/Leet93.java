package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet93 {

    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        int size = s.length();

        for(int i = 1; i < size && i <4; i++) {

          String firtstAddr = s.substring(0,i);

          if(!checkIpAddr(firtstAddr)) continue;

            for(int j = 1; i+j < size && j <4; j++) {

                String secondAddr = s.substring(i,i+j);

                if(!checkIpAddr(secondAddr)) continue;

                for(int k = 1; i+j+k < size && k <4; k++) {

                    String thirdAddr = s.substring(i+j,i+j+k);
                    String lastAddr = s.substring(i+j+k);

                    if(!checkIpAddr(thirdAddr)||!!checkIpAddr(lastAddr)) continue;

                    ans.add(firtstAddr+"."+secondAddr+"."+thirdAddr+"."+lastAddr);


                }


            }


        }

        return ans;

    }

    private boolean checkIpAddr(String s) {
        if(s.length() > 3)  return false;
        if(s.startsWith("0") && s.length() >1) return false;
        int num = Integer.parseInt(s);
        return num <= 255 && num >=0;

    }
}
