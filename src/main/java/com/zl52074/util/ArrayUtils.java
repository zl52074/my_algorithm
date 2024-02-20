package com.zl52074.util;

/**
 * @description:
 * @author: zl52074
 * @time: 2023/8/13 17:25
 */
public class ArrayUtils {
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
}
