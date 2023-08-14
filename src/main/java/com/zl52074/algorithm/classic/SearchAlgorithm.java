package com.zl52074.algorithm.classic;

import org.junit.Test;

import java.util.Arrays;

import static com.zl52074.algorithm.classic.SortAlgorithm.quickSort;
import static com.zl52074.util.NumberUtil.randomNumber;

/**
 * @description: 经典查找算法
 * @author: zl52074
 * @time: 2023/8/14 18:05
 */
public class SearchAlgorithm {

    /**
     * @description 二分查找
     * 静态查找表 有序序列
     * @param array 数组
     * @param key 待查找元素
     * @return int 元素下标
     * @author zl52074
     * @time 2023/8/14 18:16
     */
    public static int binarySearch(int[] array,int key){
        int index = -1;
        int start = 0;
        int end = array.length - 1;
        int count = 0;
        while (start <= end) {
            System.out.println(++count);
            int middle = (start + end) / 2;
            if (key > array[middle]) {
                start = middle + 1;
            } else if (key < array[middle]) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return index;
    }
    @Test
    public void binarySearchTest(){
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        long start = System.currentTimeMillis();
        int result = binarySearch(array,9);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println(end - start+"ms");
    }



    @Test
    public void performanceTest(){
        int len = 10000000;
        int[] array = new int[len];
        for(int i = 0;i<len;i++){
            array[i] = randomNumber(1,len);
        }
        quickSort(array,0,len-1);
        int[] binarySearchArray = Arrays.copyOf(array,array.length);
        // int keyIndex = randomNumber(1,len);
        int keyIndex = len-1;
        System.out.println("keyIndex: "+keyIndex+"  key: "+binarySearchArray[keyIndex]);
        long binarySearchStart = System.currentTimeMillis();
        int binarySearchResult =  binarySearch(binarySearchArray,binarySearchArray[keyIndex]);
        long binarySearchEnd = System.currentTimeMillis();
        System.out.println("binarySearchResult: "+binarySearchResult+"  "+binarySearchArray[binarySearchResult]);
        System.out.println("binarySearch: "+(binarySearchEnd - binarySearchStart)+"ms");

    }
}
