package com.zl52074.algorithm.classic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 经典算法
 * @author: zl52074
 * @time: 2021/9/1 21:41
 */
public class ClassicAlgorithm {

    /***
     * @description 水仙花数
     * 水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身。例如：1^3 + 5^3+ 3^3 = 153
     * @return void
     * @time 2021/9/1 21:46
     */

    public static void narcissisticNumber(){
        for (int i = 100; i < 1000; i++) {
            //拆分当前数字的每一位，模10取余，除10取整
            int one = i % 10; //取个位余数
            int ten = i / 10 % 10;
            int hundred = i / 100;
            if (one * one * one + ten * ten * ten + hundred * hundred * hundred == i) {
                System.out.println(i);
            }
/*            if (Math.pow(i % 10, 3) + Math.pow((i / 10) % 10, 3) + Math.pow(i / 100, 3) == i) {
                System.out.println(i);
            }*/
        }
    }
    @Test
    public void narcissisticNumberTest(){
        narcissisticNumber();
    }

    /***
     * @description 斐波那契数列
     * 形如 0、1、1、2、3、5、8、13、21、34的数列，推导公式 F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）
     * @param end 结束范围（数列长度）
     * @return void
     * @time 2021/9/2 22:55
     */
    public static void fibonacci(int end) {
        long num1 = 0;
        long num2 = 1;
        long sum = 0;
        System.out.print(num1 + " ");
        System.out.print(num2 + " ");
        for (int i = 0; i < end; i++) {
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
            System.out.print(sum + " ");
        }

    }
    @Test
    public void fibonacciTest(){
        fibonacci(50);
    }

    /**
     * @description 质数
     * 质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。
     * @param end 结束范围
     * @return void
     * @time 2021/9/3 0:13
     */
    public static void primeNumber(int end) {
        for (int i = 2; i < end; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + " ");
            }

        }

    }
    @Test
    public void primeNumberTest(){
        primeNumber(100);
    }



    /**
     * @description 杨辉三角
     * 0：[1]
     * 1：[1, 1]
     * 2：[1, 2, 1]
     * 3：[1, 3, 3, 1]
     * 4：[1, 4, 6, 4, 1]
     * 5：[1, 5, 10, 10, 5, 1]
     * 6：[1, 6, 15, 20, 15, 6, 1]
     * 7：[1, 7, 21, 35, 35, 21, 7, 1]
     * 8：[1, 8, 28, 56, 70, 56, 28, 8, 1]
     * 9：[1, 9, 36, 84, 126, 126, 84, 36, 9, 1]
     * triangleArray[i][j] = triangleArray[i - 1][j - 1] + triangleArray[i - 1][j];
     * @param
     * @return void
     * @author zl52074
     * @time 2023/8/13 16:12
     */
    public static void yanghuiTriangle() {
        int[][] triangleArray = new int[10][];
        for (int i = 0; i < triangleArray.length; i++) {
            triangleArray[i] = new int[i + 1];
            for (int j = 0; j < triangleArray[i].length; j++) {
                if (j == 0 || j == triangleArray[i].length - 1) {
                    triangleArray[i][j] = 1;
                } else {
                    triangleArray[i][j] = triangleArray[i - 1][j - 1] + triangleArray[i - 1][j];
                }
            }
            System.out.println(i + "：" + Arrays.toString(triangleArray[i]));
        }
    }
    @Test
    public void yanghuiTriangleTest(){
        yanghuiTriangle();
    }

}
