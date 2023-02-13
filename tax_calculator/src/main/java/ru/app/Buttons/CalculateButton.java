package ru.app.Buttons;

import ru.app.Order;

public class CalculateButton extends ButtonFather{
    public CalculateButton(String name) {
        super(name);
    }
    @Override
    public void buttonAction() {
        if (Order.validFields()) {
            Order.Calculate();
        }
    }
}
