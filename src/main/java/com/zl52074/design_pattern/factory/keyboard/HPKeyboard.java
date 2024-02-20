package com.zl52074.design_pattern.factory.keyboard;

/**
 * @description: 惠普键盘
 * @author: zl52074
 * @time: 2023/12/2 19:05
 */
public class HPKeyboard implements Keyboard {
    @Override
    public void input() {
        System.out.println("HP Keyboard");
    }
}
