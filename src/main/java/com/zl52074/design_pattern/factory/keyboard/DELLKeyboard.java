package com.zl52074.design_pattern.factory.keyboard;

/**
 * @description: 戴尔键盘
 * @author: zl52074
 * @time: 2023/12/2 19:05
 */
public class DELLKeyboard implements Keyboard {
    @Override
    public void input() {
        System.out.println("DELL Keyboard");
    }
}
