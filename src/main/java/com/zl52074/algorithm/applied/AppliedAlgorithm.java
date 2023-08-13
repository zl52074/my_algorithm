package com.zl52074.algorithm.applied;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: 应用型算法
 * @author: zl52074
 * @time: 2021/9/1 21:40
 */
public class AppliedAlgorithm {

    /***
     * @description 数字分离
     * 不使用字符串操作，将任意位数数字的每一位分离出来
     * @param number 任意数字
     * @return void
     * @time 2021/9/2 21:21
     */
    public static void splitNum(int number) {
        List<Integer> list = new ArrayList<>();
        int figuresCount = 0;
        while (number > 0) {
            int remainder = number % 10; //取个位余数
            number = number / 10; //利用丢失精度舍去个位
            list.add(remainder);
            figuresCount++;
        }
        Collections.reverse(list);
        System.out.println(list);
        System.out.println(figuresCount);
    }

    @Test
    public void splitNumTest() {
        splitNum(12345);
    }

    /**
     * @description 反转数组
     * 将一个数组头尾反转 如[1,2,3]反转之后为[3,2,1]
     * @param array 源数组
     * @return int[]
     * @time 2021/9/2 21:40
     */
    public static int[] reverseArray(int[] array) {
        //数组折半，对称互换元素
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        //双指针
        int j = array.length - 1;
        for (int i = 0; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    @Test
    public void reverseArrayTest() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverseArray(a);
        System.out.println(Arrays.toString(a));
    }


    /**
     * @description 回文判断
     * “回文串”是一个正读和反读都一样的字符串，如“level”或者“noon”，判断源文本是否为回文
     * @param str 源文本
     * @return void
     * @time 2021/9/2 21:58
     */
    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        boolean flag = true;
        //数组折半，对称比较值是否一致
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[0 + i] != chars[chars.length - 1 - i]) {
                flag = false;
                break;
            }
        }
        //双指针
        int j = chars.length - 1;
        for (int i = 0; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Test
    public void isPalindromeTest() {
        System.out.println(isPalindrome("level"));
    }

    /**
     * @description 数值交换
     * 不借助中间变量实现两个数值型变量的数值交换
     * @param
     * @return void
     * @time 2021/9/2 22:35
     */
    public static void swapNum() {
        int num1 = 4;
        int num2 = 6;
        num1 = num1 ^ num2; //^(异或)
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        // 00000100^00000110 = 00000010 num1 = 2
        // 00000010^00000110 = 00000100 num2 = 4
        // 00000010^00000100 = 00000110 num1 = 6
        System.out.println(num1);
        System.out.println(num2);
    }

    @Test
    public void swapNumTest() {
        swapNum();
    }

    /**
     * @description 完数
     * 一个数恰好等于它的真因子（除去自身之外的因子）之和 如 6 = 1 + 2 + 3
     * @param end 结束范围
     * @return void
     * @time 2021/9/3 0:42
     */
    public static void prefectNumber(int end) {
        for (int i = 2; i < end; i++) {
            int sum = 1;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sum += j;
                    sum += i / j;
                    // sum += i / j != i ? i / j : 0; //两个不同的因子，实际上重复因子的数不可能是完数
                }
            }
            if (sum == i) {
                System.out.print(i + " ");
            }
        }
    }
    @Test
    public void prefectNumberTest() {
        long start = System.currentTimeMillis();
        prefectNumber(1000000);
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }


    /**
     * @description 求任意两个正整数的最大公约数与最小公倍数
     * @param m 正整数m
     * @param n 正整数n
     * @return void
     * @author zl52074
     * @time 2023/8/13 16:05
     */
    public static void numberCalculate(int m,int n) {
        int max = m > n ? m : n;
        int min = m < n ? m : n;
        //最大公约数，反向遍历
        for (int i = min; min >= 1; i--) {
            if (m % i == 0 && n % i == 0) {
                System.out.println(i);
                break;
            }
        }
        //最小公倍数，遍历增加最大数的倍数，直到倍数等于最小数的值（即两数的乘积）
        for (int i = 1; i <= min; i++) {
            if (max * i % min == 0) {
                System.out.println(max * i);
                break;
            }
        }
    }
    @Test
    public void numberCalculateTest() {
        numberCalculate(10,100);
    }


    /**
     * @description 回形数
     * 1  2  3  4  5
     * 16 17 18 19 6
     * 15 24 25 20 7
     * 14 23 22 21 8
     * 13 12 11 10 9
     * @param
     * @return void
     * @author zl52074
     * @time 2023/8/13 17:48
     */
    public static void huiNumber(int len) {
        int[][] array = new int[len][len];
        int direction = 1; //方向标识
        int x = 0;
        int y = 0;
        for (int i = 1; i <= len * len; i++) {
            if (direction  == 1) {
                if (y < len && array[x][y] == 0) {
                    array[x][y] = i;
                    y++;
                } else {
                    y--;
                    x++;
                    direction=2;
                    i--;
                }
            } else if (direction  == 2) {
                if (x < len && array[x][y] == 0) {
                    array[x][y] = i;
                    x++;
                } else {
                    x--;
                    y--;
                    direction=3;
                    i--;
                }
            }else if (direction == 3) {
                if (y >= 0 && array[x][y] == 0) {
                    array[x][y] = i;
                    y--;
                } else {
                    y++;
                    x--;
                    direction= 4;
                    i--;
                }
            }else if (direction == 4) {
                if (x >=0 && array[x][y] == 0) {
                    array[x][y] = i;
                    x--;
                }else {
                    x++;
                    y++;
                    direction = 1;
                    i--;
                }
            }
        }
        for (int j = 0; j < len; j++) {
            System.out.println(Arrays.toString(array[j]));
        }
    }

}
