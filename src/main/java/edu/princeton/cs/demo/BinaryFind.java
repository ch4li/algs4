package edu.princeton.cs.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryFind {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 24, 53, 5, 3, 8, 243, 6, 23, 643, 9);
        Collections.sort(integers);
        System.out.println("binaryFind(arrayList, 23) = " + binaryFind(integers, 23));


    }

    public static int binaryFind(List<Integer> list, int key) {
//        Arrays.sort(arrayList);
        int high = list.size();
        int low = 0;
        int mid = low + (high - low) / 2;
        int midValue = list.get(mid);

//        if (source == midValue)  // binaryFind(arrayList, 23) = false
        // 超级奇怪，满足条件居然不返回值，还执行source < midvalue 返回false
        if (low == high ) return -1;
        else if (key > midValue) {
            System.out.println(key + " : " + midValue);
            binaryFind( list.subList(mid + 1, high), key);
        } else if (key < midValue) {
            System.out.println(key + " : " + midValue);
            binaryFind(list.subList(low, mid - 1), key);
        } return midValue;
    }
}
