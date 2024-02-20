package com.zl52074.util;

import org.junit.Test;

/**
 * @description:
 * @author: zl52074
 * @time: 2023/8/13 17:25
 */
public class NumberUtils {
    /**
     * @description 生成指定范围的随机数
     * 1、Math类的random()的调用，会返回一个[0.0,1.0)范围的一个double型值
     * 2、Math.random() * 100 ---> [0,100)  (int)(Math.random() * 100) ---> [0,99]  (int)(Math.random() * 100) + 5 ----> [5,104]
     * 3、如何获取[min,max]范围内的随机整数呢？(int)(Math.random() * (max - min + 1))+min
     * 或者用Random类[min,max) n=new Random().nextInt(max-min+1)+min
     * @param start 开始
     * @param end 结束
     * @return void
     * @author zl52074
     * @time 2023/8/13 16:45
     */
    public static int randomNumber(int start, int end) {
        return (int) (Math.random() * (end - start + 1)) + start;
    }
    @Test
    public void randomNumberTest() {
        System.out.println(randomNumber(1,100));
        java.util.Calendar.getInstance();
        java.text.NumberFormat.getInstance();

    }
}
