package com.zl52074.algorithm.classic;

import org.junit.Test;

import java.util.Arrays;
import static com.zl52074.util.NumberUtil.randomNumber;

/**
 * @description: 经典排序算法
 * @author: zl52074
 * @time: 2023/8/13 15:44
 */
public class SortAlgorithm {


    /**
     * @description 冒泡排序
     * @param array 数组
     * @return void
     * @author zl52074
     * @time 2023/8/13 16:27
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    @Test
    public void bubbleSortTest(){
        int[] array = new int[]{5, 7, 9, 4, 3, 1, 1, 2, 8, 6};
        long start = System.currentTimeMillis();
        bubbleSort(array);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println(end - start+"ms");
    }



    /**
     * @description 快速排序
     * @param array 数组
     * @param start 数组起始下标
     * @param end 数组结束下标
     * @return void
     * @author zl52074
     * @time 2023/8/13 16:28
     */
    public static void quickSort(int[] array, int start, int end) {
        int key = array[start];
        int flag = 0;
        int pleft = start;
        int pright = end;
        while (pleft < pright) {
            if (flag == 0) {
                if (array[pright] < key) {
                    array[pleft] = array[pright];
                    flag = 1;
                    pleft++;
                } else {
                    pright--;
                }
            } else {
                if (array[pleft] > key) {
                    array[pright] = array[pleft];
                    flag = 0;
                    pright--;
                } else {
                    pleft++;
                }
            }
        }
        array[pleft] = key;
        if (pleft - 1 > start) {
            quickSort(array, start, pleft - 1);
        }
        if (pleft + 1 < end) {
            quickSort(array, pleft + 1, end);
        }
    }
    @Test
    public  void quickSortTest() {
        int[] array = new int[]{5, 7, 9, 4, 3, 1, 1, 2, 8, 6};
        long start = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println(end - start+"ms");
    }


    @Test
    public void performanceTest(){
        int len = 10000;
        int[] array = new int[len];
        for(int i = 0;i<len;i++){
            array[i] = randomNumber(1,len);
        }
        int[] quickSortArray = Arrays.copyOf(array,array.length);
        int[] bubbleSortArray = Arrays.copyOf(array,array.length);

        long bubbleSortStart = System.currentTimeMillis();
        bubbleSort(bubbleSortArray);
        long bubbleSortEnd = System.currentTimeMillis();
        // System.out.println(Arrays.toString(array));
        System.out.println("bubbleSort: "+(bubbleSortEnd - bubbleSortStart)+"ms");

        long quickSortStart = System.currentTimeMillis();
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        long quickSortEnd = System.currentTimeMillis();
        // System.out.println(Arrays.toString(array));
        System.out.println("quickSort: "+(quickSortEnd - quickSortStart)+"ms");


    }
}
