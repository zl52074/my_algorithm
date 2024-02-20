package com.zl52074.design_pattern.factory.monitor;

/**
 * @description: 戴尔键盘
 * @author: zl52074
 * @time: 2023/12/2 19:10
 */
public class DELLMonitor implements Monitor{
    @Override
    public void display() {
        System.out.println("HP Monitor");
    }
}
