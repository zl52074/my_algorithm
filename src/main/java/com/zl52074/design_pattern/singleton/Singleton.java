package com.zl52074.design_pattern.singleton;

/**
 * 静态内部类方式（懒汉式）
 * @author: zl52074
 * @time: 2023/12/2 17:38
 */

public class Singleton {
    private Singleton() {}

    // 静态内部类
    private static class HolderClass {
        private final static Singleton instance = new Singleton();
    }
    //当主动调用此方法才会加载HolderClass类并初始化实例
    public static Singleton getInstance() {
        return HolderClass.instance;
    }

}











