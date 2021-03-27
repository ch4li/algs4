package edu.princeton.cs.demo;

import edu.princeton.cs.domain.ResizingArrayStack;
import edu.princeton.cs.domain.CapacityStackOfStringArray;

import java.util.Iterator;

/**
 * @author amazm
 */
public class StackDemo {

    public static void main(String[] args) {
        Double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0, 0.0, 6.0, 0.0, 0.0, 7.0, 0.0, 0.0, 0.0, 8.0};
        String[] text = {"to", "be", "or", "not","to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        printStack4StringArray(text);
        printStack4GenericArray(text, "-");
    }


    public static void printStack4StringArray(String[] array) {

        CapacityStackOfStringArray stack = new CapacityStackOfStringArray(100);

        for (String item : array) {
            if (!item.equals("-")) {
                stack.push(item);
            } else {
                System.out.print(stack.pop() + " ");

           }

        }
        System.out.println("\nstack.spaceLength() = " + stack.spaceLength());
        System.out.println("(left " + stack.size() + " on stack)" );
    }

    /** 升级为泛型 */
    public static void printStack4GenericArray(Object[] array, Object popFlag) {

        ResizingArrayStack stack = new ResizingArrayStack();

        for (Object item : array) {
            if (!item.equals(popFlag)) {
                stack.push(item);

            } else {
                System.out.print(stack.pop() + " ");

           }

        }
        Iterator iter = stack.iterator();

        System.out.println("~~~~~~~~~~~~~~");
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("\nstack.spaceLength() = " + stack.spaceLength());
        System.out.println("(left " + stack.size() + " on stack)" );
    }

}
