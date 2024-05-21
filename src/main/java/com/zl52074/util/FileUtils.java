package com.zl52074.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @description:
 * @author: zl52074
 * @time: 2024/2/20 18:05
 */
public class FileUtils {
    public static void objectToFile(Object obj, String filePath) {
        try{
            // 将对象序列化到文件
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(obj);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Object fileToObject(String filePath) {
        try {
            // 从文件中反序列化对象
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
