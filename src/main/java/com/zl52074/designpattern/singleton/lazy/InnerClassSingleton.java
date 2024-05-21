package com.zl52074.designpattern.singleton.lazy;

/**
 * 静态内部类方式（懒汉式）
 * @author: zl52074
 * @time: 2023/12/2 17:38
 */

public class InnerClassSingleton {
    private InnerClassSingleton() {}

    // 静态内部类
    private static class HolderClass {
        private final static InnerClassSingleton instance = new InnerClassSingleton();
    }
    //当主动调用此方法才会加载HolderClass类并初始化实例
    public static InnerClassSingleton getInstance() {
        return HolderClass.instance;
    }

}











