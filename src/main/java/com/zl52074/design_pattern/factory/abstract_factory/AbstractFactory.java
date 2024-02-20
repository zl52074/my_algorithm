package com.zl52074.design_pattern.factory.abstract_factory;

import com.zl52074.design_pattern.factory.keyboard.Keyboard;
import com.zl52074.design_pattern.factory.monitor.Monitor;

public interface AbstractFactory {
    Keyboard getKeyboardInstance();
    Monitor getMonitorInstance();
}
