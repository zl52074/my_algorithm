package com.zl52074.design_pattern.singleton;

/**
 * 饿汉式
 * @author: zl52074
 * @time: 2023/12/2 18:17
 */
public class HungrySingleton implements Cloneable{
    // 类加载，初始化
    private static final HungrySingleton instance = new HungrySingleton();

    //构造器私有化
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
