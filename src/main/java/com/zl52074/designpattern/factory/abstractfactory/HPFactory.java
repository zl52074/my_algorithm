package com.zl52074.designpattern.factory.abstractfactory;

import com.zl52074.designpattern.factory.keyboard.HPKeyboard;
import com.zl52074.designpattern.factory.keyboard.Keyboard;
import com.zl52074.designpattern.factory.monitor.HPMonitor;
import com.zl52074.designpattern.factory.monitor.Monitor;

/**
 * @description:
 * @author: zl52074
 * @time: 2023/12/3 1:36
 */
public class HPFactory implements AbstractFactory{
    @Override
    public Keyboard getKeyboardInstance() {
        return new HPKeyboard();
    }

    @Override
    public Monitor getMonitorInstance() {
        return new HPMonitor();
    }
}
