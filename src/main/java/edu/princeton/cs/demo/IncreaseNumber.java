package edu.princeton.cs.demo;

/**
 * @author amazm
 * 从字节码看i++ 和 ++i 的区别
 *
 */
public class IncreaseNumber {

    public static void main(String[] args) {
        int tempA;
        int i = 0;
        tempA = i ++;
        tempA = i ++;
        tempA = i ++;
        System.out.println(tempA);

        int j = 0;
        int tempB;
        tempB = ++j;
        tempB = ++j;
        tempB = ++j;
        System.out.println(tempB);
    }
}
