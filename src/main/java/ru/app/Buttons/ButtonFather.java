package ru.app.Buttons;

import javax.swing.*;

public abstract class ButtonFather extends JButton {
    public ButtonFather(String name) {
        super(name);
        this.addActionListener(e -> buttonAction());
    }
    public abstract void buttonAction();
}
