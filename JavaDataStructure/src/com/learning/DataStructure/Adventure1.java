package com.learning.DataStructure;

import java.util.*;

public class Adventure1 {
    public static void main(String[] args) {

        int size;
        List<String> list = new ArrayList<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add(1, "J");

        size = list.size();

        System.out.println("저장된 객체의 수 : " + size);

        for(int i = 0 ; i < size ; i ++){
            System.out.println(i + "번째 : " + list.get(i) + "\n");
        }

        System.out.println("\n"+"----- 변경후 -----"+"\n");

        list.remove(1);
        list.remove(1);

        size = list.size();

        for(int i = 0 ; i < size ; i ++){
            System.out.println(i + "번째 : " + list.get(i) + "\n");
        }



    }
}
