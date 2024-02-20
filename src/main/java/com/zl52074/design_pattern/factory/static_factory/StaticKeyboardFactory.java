package com.zl52074.design_pattern.factory.static_factory;

import com.zl52074.design_pattern.factory.keyboard.DELLKeyboard;
import com.zl52074.design_pattern.factory.keyboard.HPKeyboard;
import com.zl52074.design_pattern.factory.keyboard.Keyboard;

/**
 * @description: 简单工厂
 * @author: zl52074
 * @time: 2023/12/2 19:12
 */
public class StaticKeyboardFactory {
    public Keyboard getInstance(String brand) {
        if ("HP".equals(brand)) {
            return new HPKeyboard();
        } else if ("DELL".equals(brand)) {
            return new DELLKeyboard();
        }
        return null;
    }
}
