package edu.princeton.cs.demo;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

// 随机数组图像
public class TestRandomArrayPoint {

    public static void main(String[] args) {
        int number = 50;
        double[] array = new double[number];


        for (int i = 0; i < number; i++) {
            array[i] = StdRandom.uniform();
            double x = i * 1.0 / number;
            double y = array[i] / 2.0;
            double width = 0.5 / number;
            double high = array[i] / 2.0;

            StdDraw.filledRectangle(x, y, width, high);
        }

    }
}
