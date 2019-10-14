package com.company.session1;




import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        String[] n ={"google","Microsoft","Apple"};
        n = ArrayUtils.removeElement(n, "google");

//        final String[] n2 = new String[5];
//        System.arraycopy(n,0,n2,1,3);
        System.out.println(Arrays.toString(n));
    }
}