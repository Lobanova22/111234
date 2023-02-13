package ru.app;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

public class Order {
    public static double tax;
    public static int powerRatio;
    public static int power;
    public static int period;
    public static double luxuryTax;
    public static int privilege;
    public static String pdfPath;
    private static BaseFont times = null;

    public static Boolean validFields() {
        if (MainForm.surnameField.getText().isEmpty()) {invalidFieldMessage("Фамилия"); return false;}
        if (MainForm.nameField.getText().isEmpty()) {invalidFieldMessage("Имя"); return false;}
        if (MainForm.patronymicField.getText().isEmpty()) {invalidFieldMessage("Отчество"); return false;}

        try {period = Integer.parseInt(MainForm.periodField.getText());}
        catch (NumberFormatException e) {invalidFieldMessage("Период");return false;}

        try {power = Integer.parseInt(MainForm.powerField.getText());}
        catch (NumberFormatException e) {invalidFieldMessage("Мощность");return false;}

        return true;
    }

    public static void Calculate() {
        initVariables();
        tax = round(powerRatio * power * (period / 12) * luxuryTax * privilege, 2);
        JOptionPane.showMessageDialog(null, "К оплате: " + tax + " рублей.", "Ваш налог посчитан", JOptionPane.INFORMATION_MESSAGE);
        MainForm.surnameField.setEnabled(false);
        MainForm.nameField.setEnabled(false);
        MainForm.patronymicField.setEnabled(false);
        MainForm.powerField.setEnabled(false);
        MainForm.periodField.setEnabled(false);
        MainForm.benefitBox.setEnabled(false);
        MainForm.luxuryBox.setEnabled(false);
        MainForm.calculateButton.setEnabled(false);
        MainForm.pdfButton.setEnabled(true);
    }

    public static void initVariables() {
        if (power<=100) {powerRatio =25;}
        else if (power<=150) {powerRatio =35;}
        else if (power<=200) {powerRatio =50;}
        else if (power<=250) {powerRatio =75;}
        else {powerRatio =150;}

        switch (Objects.requireNonNull(MainForm.benefitBox.getSelectedItem()).toString()) {
            case "Нет льгот":
                privilege = 1;
                break;
            case "Один из родителей (усыновитель) либо опекун (попечитель) в семье, которая признается многодетной":
            case "Герои Советского Союза, Герои Российской Федерации, герои Социалистического Труда, полные кавалеры ордена Славы, полные кавалеры ордена Трудовой Славы":
            case "Инвалиды всех категорий, ветераны Великой Отечественной войны, ветераны боевых действий на территории СССР, на территории Российский Федерации и территориях других государств, ветераны военной службы, ветераны труда, категории граждан, подвергшихся воздействию радиации вследствие чернобыльской катастрофы":
                if (power<=150) {privilege = 0;}
                else {privilege = 1;}
                break;
        }

        switch (Objects.requireNonNull(MainForm.luxuryBox.getSelectedItem()).toString()) {
            case "Без налога на роскошь" -> luxuryTax = 1;
            case "Автомобиль стоит от 3 до 5млн. руб., возраст не более 3 лет" -> luxuryTax = 1.1;
            case "Автомобиль стоит от 5 до 10 млн. руб., возраст не более 5 лет" -> luxuryTax = 2;
            case "Автомобиль стоит от 10 до 15 млн. руб., возраст не более 10 лет", "Автомобиль стоит от 15 млн. Руб., возраст не более 20 лет" ->
                    luxuryTax = 3;
        }
    }

    public static void GeneratePDF() throws IOException, URISyntaxException {
        CreatePDF pdf = new CreatePDF();
        pdf.Create();

        MainForm.surnameField.setEnabled(true);
        MainForm.nameField.setEnabled(true);
        MainForm.patronymicField.setEnabled(true);
        MainForm.powerField.setEnabled(true);
        MainForm.periodField.setEnabled(true);
        MainForm.benefitBox.setEnabled(true);
        MainForm.luxuryBox.setEnabled(true);

        MainForm.calculateButton.setEnabled(true);
        MainForm.pdfButton.setEnabled(false);
    }

    public static void invalidFieldMessage(String field) {
        JOptionPane.showMessageDialog(null, "Ошибка с полем " + field + ". Поле не должно быть пустым или содержать некорректные значения.", " Ошибка!", JOptionPane.ERROR_MESSAGE);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
