package ru.app.Buttons;

import ru.app.Order;

import java.io.IOException;
import java.net.URISyntaxException;

public class PDFButton extends ButtonFather{
    public PDFButton(String name) {
        super(name);
    }
    @Override
    public void buttonAction() {
        try {
            Order.GeneratePDF();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
