package com.zl52074.design_pattern.factory.abstract_factory;

import com.zl52074.design_pattern.factory.keyboard.DELLKeyboard;
import com.zl52074.design_pattern.factory.keyboard.Keyboard;
import com.zl52074.design_pattern.factory.monitor.DELLMonitor;
import com.zl52074.design_pattern.factory.monitor.Monitor;

/**
 * @description:
 * @author: zl52074
 * @time: 2023/12/3 1:36
 */
public class DELLFactory implements AbstractFactory{
    @Override
    public Keyboard getKeyboardInstance() {
        return new DELLKeyboard();
    }

    @Override
    public Monitor getMonitorInstance() {
        return new DELLMonitor();
    }
}
