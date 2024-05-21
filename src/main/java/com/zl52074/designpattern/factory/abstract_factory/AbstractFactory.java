package com.zl52074.designpattern.factory.abstract_factory;

import com.zl52074.designpattern.factory.keyboard.Keyboard;
import com.zl52074.designpattern.factory.monitor.Monitor;

public interface AbstractFactory {
    Keyboard getKeyboardInstance();
    Monitor getMonitorInstance();
}
