package edu.princeton.cs.domain;

import java.util.Iterator;

/**
 * @author amazm
 * 创建固定容量到数组
 */
public class ResizingArrayStack<Item> {

    /**
     * 自动伸缩容量
     * 初始化为array[0] = 0 ,至少指定容量个数(>0)
     * 才能使用resize裁剪
     */
    final private static int INITIAL_CAPACITY = 8;
    private Item[] array;
    private int n;


    public ResizingArrayStack() {
        array = (Item[]) new Object[INITIAL_CAPACITY];
        n = 0;
    }

    /**
     * 自定义容量, 一开始是100,不会满足条件触发resize
     * public CapacityStackOfGeneric(int capacity) {
     * array = (Item[]) new Object[capacity];
     * }
     */


    public Integer size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Item item) {
        if (n == array.length) {
            resize(array.length * 2);
        }
        // 此处游走的N,是自增后N+1
        array[n++] = item;
    }

    public Item pop() {
        // 所以要让L30游走的N+1,先N自减, 然后返回真实列表中的array[N]
        // N-- ++N 正负相吸,对称设计,保证清除游走的值影响
        // 优先计算(中)括号内容的表达式,再计算(中)括号外的.
        Item popElement = array[--n];
        // 防止对象游离
        array[n] = null;
//        final float BOUND = 1 / 4F;
        if (n > 0 && n == array.length / 4) {
            resize(array.length / 2);
        }
        return popElement;
    }

    public Integer spaceLength() {
        return array.length;
    }


    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = array[i];

        }
        // 覆盖旧地址,变成大小合适的容器
        array = copy;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return array[--i];
        }

        @Override
        public void remove() {

        }
    }
}
