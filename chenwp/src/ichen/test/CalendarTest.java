package ichen.test;

import java.util.*;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        int month = calendar.get(2)+1;
        System.out.println(month);
        String.valueOf(month);
        List list=new ArrayList();
        Integer[] arr=new Integer[]{1,2,3,4,5,6,7,8,9,10};
        list.addAll(Arrays.asList(arr));

        if (list.contains(month)){
            System.out.println("4季度");
        }
    }
}
