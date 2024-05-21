package com.zl52074.datastructures.array;

import com.zl52074.util.FileUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 稀疏数组
 * @author: zl52074
 * @time: 2024/2/20 16:55
 *  0	0	0	0	0
 *  0	0	1	0	0
 *  0	0	0	2	0
 *  0	0	0	0	0
 *  0	0	0	0	0
 * =========================================
 *  5	5	2
 *  1	2	1
 *  2	3	2
 */
public class SparseArray {
    /**
     * 将原始二维数组转换为稀疏数组
     * @param originArray 原始二维数组
     * @return 稀疏数组
     */

     /*
    public static int[][] toSparseArray(int[][] originArray) {
        // 计算原始数组中非零元素的数量
        int sum = 0;
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray[0].length; j++) {
                if (originArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 创建一个新的二维数组来存储稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = originArray.length;
        sparseArray[0][1] = originArray[0].length;
        sparseArray[0][2] = sum;
        // 遍历原始数组，将非零元素的位置和值存储在稀疏数组中
        int index = 0;
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray[0].length; j++) {
                if (originArray[i][j] != 0) {
                    index++;
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = originArray[i][j];
                }
            }
        }
        return sparseArray;
    }*/

    public static int[][] toSparseArray(int[][] originArray) {
        //使用list可以动态的添加元素
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{originArray.length, originArray[0].length, 0});
        for (int i = 0; i < originArray.length; i++) {
            for (int j = 0; j < originArray[0].length; j++) {
                if (originArray[i][j] != 0) {
                    //将非零元素的位置和值存储在稀疏数组中
                    list.add(new int[]{i, j, originArray[i][j]});
                    //更新非零元素的数量
                    list.get(0)[2]++;
                }
            }
        }
        return list.toArray(new int[0][]);
    }

    /**
     * 将稀疏数组转换回原始二维数组
     * @param sparseArray 稀疏数组
     * @return 原始二维数组
     */
    public static int[][] toOriginArray(int[][] sparseArray) {
        // 从稀疏数组中获取原始数组的大小
        int length = sparseArray[0][0];
        int width = sparseArray[0][1];
        // 创建一个新的二维数组来存储原始数组
        int[][] originArray = new int[length][width];
        // 遍历稀疏数组，将元素的位置和值恢复到原始数组中
        for (int i = 1; i < sparseArray.length; i++) {
            int x = sparseArray[i][0];
            int y = sparseArray[i][1];
            int value = sparseArray[i][2];
            originArray[x][y] = value;
        }
        return originArray;
    }

    /**
     * 打印二维数组的所有元素
     * @param array 二维数组
     */
    public static void printArray(int[][] array) {
        // 遍历数组的每一行和每一列，然后打印出每个元素
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        // 创建一个原始的二维数组
        int[][] originArray = new int[5][5];
        originArray[1][2] = 1;
        originArray[2][3] = 2;
        // 使用toSparseArray方法将其转换为稀疏数组并打印出来
        printArray(originArray);
        System.out.println("=========================================");
        int[][] sparseArray = toSparseArray(originArray);
        printArray(sparseArray);
        // 使用toOriginArray方法将稀疏数组转换回原始数组并再次打印出来
        System.out.println("=========================================");
        FileUtils.objectToFile(sparseArray, "d:/test/sparseArray.data");
        int[][] array = toOriginArray((int[][]) FileUtils.fileToObject("d:/test/sparseArray.data"));
        printArray(array);
    }
}
