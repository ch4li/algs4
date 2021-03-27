package edu.princeton.cs.demo;

import edu.princeton.cs.algs4.StdDraw;

public class TestStdDraw {
    public static void main(String[] args) {
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLUE);
//        StdDraw.point(0.5, 0.5);
//        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);

        StdDraw.circle(0, 0,0.2);
        StdDraw.square(0.1,0.3,0.2);
        StdDraw.point(0.1,0.4);
    }
}