package ru.app.Buttons;

import javax.swing.*;

public class AboutUsButton extends ButtonFather{
    public AboutUsButton(String name) {
        super(name);
    }
    @Override
    public void buttonAction() {
        JOptionPane.showMessageDialog(null, "Лобанова Диана Владимировна - 19130014\nИмаев Булат Рустемович - 19130624", "Информация о разработчиках", JOptionPane.INFORMATION_MESSAGE);
    }
}
