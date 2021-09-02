package com.zl52074.algorithm.applied;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description: 应用型算法
 * @author: zl52074
 * @time: 2021/9/1 21:40
 */
public class AppliedAlgorithm {

    /***
     * @description 数字分离
     * 不使用字符串操作，将任意位数数字的每一位分离出来
     * @param num 任意数字
     * @return void
     * @time 2021/9/2 21:21
     */
    public static void splitNum(long num){
        String numLog = num+"\t";
        String remainderLog = "";
        while(num>0){
            //模10取余
            remainderLog += (num%10)+"\t";
            //除10取整
            num /= 10;
            if(num>0){
                numLog += num+"\t";
            }
        }
        System.out.println(numLog);
        System.out.println(remainderLog);
    }
    @Test
    public void splitNumTest(){
        splitNum(123);
    }

    /**
     * @description 反转数组
     * 将一个数组头尾反转 如[1,2,3]反转之后为[3,2,1]
     * @param array 源数组
     * @return int[]
     * @time 2021/9/2 21:40
     */
    public static int[] reverseArray(int[] array){
        //数组折半，对称互换元素
        for(int i = 0;i<array.length/2;i++){
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
        //双指针
        int j = array.length-1;
        for(int i = 0;i<j;i++,j--){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
    @Test
    public void reverseArrayTest(){
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
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
    public static boolean isPalindrome(String str){
        char[] chars = str.toCharArray();
        boolean flag = true;
        //数组折半，对称比较值是否一致
        for(int i = 0;i<chars.length/2;i++){
            if(chars[0+i]!=chars[chars.length-1-i]){
                flag = false;
                break;
            }
        }
        return flag;
    }
    @Test
    public void isPalindromeTest(){
        System.out.println(isPalindrome("level"));
    }

    /**
     * @description 数值交换
     * 不借助中间变量实现两个数值型变量的数值交换
     * @param
     * @return void
     * @time 2021/9/2 22:35
     */
    public static void swapNum(){
        int num1 = 4;
        int num2 = 6;
        num1 = num1^num2;
        num2 = num1^num2;
        num1 = num1^num2;
        // 00000100^00000110 = 00000010 num1 = 2
        // 00000010^00000110 = 00000100 num2 = 4
        // 00000010^00000100 = 00000110 num1 = 6
        System.out.println(num1);
        System.out.println(num2);
    }
    @Test
    public void swapNumTest(){
        swapNum();
    }

    /**
     * @description 完数
     * 一个数恰好等于它的真因子（除去自身之外的因子）之和 如 6 = 1 + 2 + 3
     * @param end 结束范围
     * @return void
     * @time 2021/9/3 0:42
     */
    public static void prefectNumber(int end){
        for (int i = 2; i < end; i++) {
            int sum = 1;
            for(int j = 2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    sum += j;
                    sum += i/j;
                }
            }
            if(sum == i){
                System.out.print(i+" ");
            }

        }
    }
    @Test
    public void prefectNumberTest(){
        long start = System.currentTimeMillis();
        prefectNumber(100000);
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println(end-start+"ms");
    }



}
