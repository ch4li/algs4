package edu.princeton.cs.demo;

/**
 * @author amazm
 */
public class IncreaseNum {

    public void increase() {
        int i = 0;
        i = i++;

        int j = 0;
        j = ++j;
    }

}


/**
 * princeton/cs/demo on  learner [!+] via ☕ v14.0.2
 * ❯ javap -c IncreaseNum.class
 * Compiled from "IncreaseNum.java"
 * public class edu.princeton.cs.demo.IncreaseNum {
 *   public edu.princeton.cs.demo.IncreaseNum();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public void increase();
 *     Code:
 *        0: iconst_0
 *        1: istore_1
 *        2: iload_1
 *        3: iinc          1, 1
 *        6: istore_1
 *        7: iconst_0
 *        8: istore_2
 *        9: iinc          2, 1
 *       12: iload_2
 *       13: istore_2
 *       14: return
 * }
 */