package com.zl52074.design_pattern.factory.monitor;

/**
 * @description: 惠普显示器
 * @author: zl52074
 * @time: 2023/12/2 19:09
 */
public class HPMonitor implements Monitor{
    @Override
    public void display() {
        System.out.println("HP Monitor");
    }
}
