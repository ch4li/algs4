package edu.princeton.cs.demo;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * @author amazm
 * 按概率p,随机连接圆圈上N等分的两个点
 */
public class RandomConnectCirclePoint {

    public static void main(String[] args) throws InterruptedException {
        int N = Integer.parseInt(String.valueOf(args[0]));
        double p = Double.parseDouble(String.valueOf(args[1]));

        // 合法性校验
        if (p < 0 || p > 1) {
            throw new InterruptedException("概率取值越界[0, 1]");
        }

        Point[] point = new Point[N];
        double radAngle = 360.0 / N;
        StdDraw.circle(0.5, 0.5, 0.5);
        StdDraw.setPenRadius(0.02);

        // 遍历构造,附带打印结果
        for (int i = 0; i < N; i++) {
            point[i] = new Point(
                    // 三角函数,根据圆角度,计算出坐标
                    0.5 + 0.5 * Math.cos(radAngle * i * Math.PI / 180),
                    0.5 + 0.5 * Math.sin(radAngle * i * Math.PI / 180)
            );
            StdDraw.point(point[i].x, point[i].y);
        }

        // 伯努利随机返回布尔值,随机连线
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.setPenRadius(0.01);
        // A:从0开始,最后倒数第二个点
        for (int i = 0; i < N - 1; i++) {
            // B: A→A无意义,所以从第二个点开始,最后选到末位的点(A→B)
            for (int j = i + 1; j < N; j++) {

            if (StdRandom.bernoulli(p)) {
                StdDraw.line(
                        point[i].x, point[i].y,
                        point[j].x, point[j].y
                );
            }
            }
        }
    }

    public static class Point {
        // 构造坐标点
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
