package edu.princeton.cs.domain;

/**
 * @author amazm
 * 创建固定容量到数组
 */
public class CapacityStackOfStringArray {

    String[] array;

    int N = 0;

    public CapacityStackOfStringArray(int capacity) {
        array = new String[capacity];
    }

    public Integer size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item) {
        // 此处游走的N,是自增后N+1
        array[N++] = item;
    }

    public String pop() {
        // 所以要让L26游走的N+1,先N自减, 然后返回真实列表中的array[N]
        // N-- ++N 正负相吸,对称设计,保证隔离游走的值影响
        // 优先计算(中)括号内容的表达式,再计算(中)括号外的.
        return array[--N];
    }

    public Integer spaceLength(){
        return array.length;
    }

}
