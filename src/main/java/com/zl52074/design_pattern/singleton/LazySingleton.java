package com.zl52074.design_pattern.singleton;

/**
 * 懒汉式（DoubleCheck + volatile保证线程安全）
 * @author: zl52074
 * @time: 2023/12/2 18:18
 */
public class LazySingleton {
    // volatile保证多线程可见性
    private volatile static LazySingleton instance = null;

    //构造器私有化
    private LazySingleton() {}

    public static LazySingleton getInstance() {
        // 第一层判断，如果实例已经创建，跳过
        if(instance == null) {
            synchronized(LazySingleton.class) {
                // 第二层判断，如果实例创建，跳过
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
