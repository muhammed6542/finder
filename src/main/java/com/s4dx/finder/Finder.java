package com.s4dx.finder;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Finder {

    private String[] thisIsAStringArray;

    public Finder(String[] thisIsAStringArray) {
        this.thisIsAStringArray = thisIsAStringArray;
    }

    public List<String> find(String str) throws Exception {
        if(str == null || "".equals(str)){
            throw new Exception("String not found") ;
        }
        if(thisIsAStringArray.length==0){
            throw new Exception("Array not found") ;
        }
        List<String> findArray = new ArrayList<>();
        char[] chrStr = str.toCharArray();
        for (int i = 0; i < thisIsAStringArray.length; i++) {

            int j = 0, t;
            boolean check, isEqual = true;

            while (chrStr.length>0&&j < chrStr.length && isEqual) {

                check = true;
                char[] fStr = thisIsAStringArray[i].toCharArray();
                t = 0;
                while (fStr.length>0 &&t < fStr.length && check) {
                    if (fStr[t] == chrStr[j]) {
                        check = false;
                    }
                    t++;
                }
                if (fStr.length==0||(fStr.length>0&&fStr[t - 1] != chrStr[j])) {
                    isEqual = false;
                }
                j++;
            }
            if (isEqual) {
                findArray.add(thisIsAStringArray[i]);
            }

        }
        return findArray;
    }

}
