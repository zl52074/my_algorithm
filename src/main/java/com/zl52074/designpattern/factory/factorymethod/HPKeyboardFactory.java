package com.zl52074.designpattern.factory.factorymethod;

import com.zl52074.designpattern.factory.keyboard.HPKeyboard;
import com.zl52074.designpattern.factory.keyboard.Keyboard;

/**
 * @description:
 * @author: zl52074
 * @time: 2023/12/3 1:30
 */
public class HPKeyboardFactory implements KeyboardFactory{

    @Override
    public Keyboard getInstance() {
        return new HPKeyboard();
    }
}
