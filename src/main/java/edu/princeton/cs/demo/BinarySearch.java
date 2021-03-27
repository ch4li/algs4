package edu.princeton.cs.demo;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1, 24, 53, 5, 3, 8, 243, 6, 23, 23, 643, 9};
        Arrays.sort(array);
//        System.out.println("binaryFind(array, 23) = " + binaryFind(array, 23));
//        System.out.println("rank(array,23) = " + rank(array, 23));
        System.out.println("count(array,23) = " + count(array, 23));
    }

    public static int binaryFind(int[] array, int key) {
        int high = array.length - 1;
        int low = 0;

        while (high != low) {
            int mid = low + (high - low) / 2;
            if (key > array[mid]) {
                low = mid + 1;
            } else if (key < array[mid]) {
                high = mid - 1;
            } else {
                return array[mid];
            }
        }
        return -1;
    }

    public static int rank(int[] array, int key) {
        int high = array.length - 1;
        int low = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (key == array[mid]) {
                while (mid >= 0 && array[mid] == key) {
                    mid--;
                }
                return mid++;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else if (key < array[mid]) {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static int count(int[] array, int key) {
        int num = 1;
        int pos = rank(array, key);
        // ++pos 返回自增后的值
//        if (pos < array.length -1 && array[pos++] == array[pos]) {
        // pos 向右移动,但不能超出右边界
        if (pos < array.length -1 && array[++pos] == array[pos]) {
            num++;
        }
        // 默认含有1了,这里不用--
        return num;
    }
}
