package com.zl52074.designpattern.factory.abstractfactory;

import com.zl52074.designpattern.factory.keyboard.Keyboard;
import com.zl52074.designpattern.factory.monitor.Monitor;

public interface AbstractFactory {
    Keyboard getKeyboardInstance();
    Monitor getMonitorInstance();
}
