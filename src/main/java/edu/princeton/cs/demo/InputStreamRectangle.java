package edu.princeton.cs.demo;

import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author amazm
 * 从输入流中获取doulbe数据,并用直方图📊画出分布数量
 */
public class InputStreamRectangle {

    public static void main(String[] args) {

        // 获取double数据,输入非double停止收录
        Scanner scanner = new Scanner(System.in);
        // 长度不定时,用数组列表,长度固定才用数组
        ArrayList<Double> list = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            list.add(scanner.nextDouble());
        }


        // 将左右区间分成N段,统计每段落点个数
        int N = Integer.parseInt(args[0]);
        double left = Double.parseDouble(args[1]), right = Double.parseDouble(args[2]);
        int[] count = new int[N];
        int max = 0;
        double step = (right - left) / N;

        for (int i = 0; i < list.size(); i++) {
            double element = list.get(i);
            // 不超过左右边界
            if (element >= left && element <= right) {
                for (int j = 0; j < N; j++) {
                    // 在本区间段内
                    if (element >= step * j && element <= step * j + step) {
                        count[j]++;
                    }
                    // 以最高段为标准,统一缩放比例
                    if (max < count[j]) {
                        max = count[j];
                    }
                }
            }

        }

        // 绘图
        for (int i = 0; i < N; i++) {
            double x = (1.0 * i + 0.5) / N;
//            double x = i;  // 太粗了,默认为1,左右两边黑白段

            double y = count[i] / (max * 4.0);
            double halfWidth = 0.4 / N;
//            double halfWidth = x / 2;  // 宽度自定义,默认为1,除以N小点
            double halfHeight = y;
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }
    }
}
