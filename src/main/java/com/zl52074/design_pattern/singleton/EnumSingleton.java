package com.zl52074.design_pattern.singleton;

import java.io.Serializable;

/**
 * 枚举方式（饿汉式，可以防止反射和克隆和反序列化对单例的破坏）
 * @author: zl52074
 * @time: 2023/12/2 18:16
 */
public enum EnumSingleton{
    INSTANCE;
}
