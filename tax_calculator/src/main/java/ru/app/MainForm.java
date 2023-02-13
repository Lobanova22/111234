package ru.app;

import ru.app.Buttons.AboutUsButton;
import ru.app.Buttons.CalculateButton;
import ru.app.Buttons.PDFButton;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    public JPanel mainPanel = new JPanel();

    public JLabel titleLabel = new JLabel("Налоговый калькулятор");
    public JLabel surnameLabel = new JLabel("Фамилия");
    public JLabel nameLabel = new JLabel("Имя");
    public JLabel patronymicLabel = new JLabel("Отчество");
    public JLabel periodLabel = new JLabel("Период (месяцы)");
    public JLabel powerLabel = new JLabel("Мощность (лошадиные силы)");
    public JLabel benefitLabel = new JLabel("Льготы");
    public JLabel luxuryLabel = new JLabel("Налог на роскошь");

    public static JTextField surnameField = new JTextField();
    public static JTextField nameField = new JTextField();
    public static JTextField patronymicField = new JTextField();
    public static JTextField periodField = new JTextField();
    public static JTextField powerField = new JTextField();

    public static JComboBox<String> benefitBox = new JComboBox<>();
    public static JComboBox<String> luxuryBox = new JComboBox<>();

    public AboutUsButton aboutUsButton = new AboutUsButton("О нас");
    public static CalculateButton calculateButton = new CalculateButton("Посчитать налог");
    public static PDFButton pdfButton = new PDFButton("Создать PDF-Документ");

    public MainForm() {
        super();

        titleLabel.setPreferredSize(new Dimension(360, 40));
        surnameLabel.setPreferredSize(new Dimension(120, 40));
        nameLabel.setPreferredSize(new Dimension(120, 40));
        patronymicLabel.setPreferredSize(new Dimension(120, 40));
        periodLabel.setPreferredSize(new Dimension(120, 40));
        powerLabel.setPreferredSize(new Dimension(120, 40));
        benefitLabel.setPreferredSize(new Dimension(120, 40));
        luxuryLabel.setPreferredSize(new Dimension(120, 40));
        surnameField.setPreferredSize(new Dimension(240, 40));
        nameField.setPreferredSize(new Dimension(240, 40));
        patronymicField.setPreferredSize(new Dimension(240, 40));
        periodField.setPreferredSize(new Dimension(240, 40));
        powerField.setPreferredSize(new Dimension(240, 40));
        benefitBox.setPreferredSize(new Dimension(240, 40));
        luxuryBox.setPreferredSize(new Dimension(240, 40));
        aboutUsButton.setPreferredSize(new Dimension(360, 40));
        calculateButton.setPreferredSize(new Dimension(360, 40));
        pdfButton.setPreferredSize(new Dimension(360, 40));

        pdfButton.setEnabled(false);

        benefitBox.addItem("Нет льгот");
        benefitBox.addItem("<html>Инвалиды всех категорий, ветераны<br>Великой Отечественной войны, <br>ветераны боевых действий на<br>территории СССР, на территории<br>Российский Федерации и территориях<br>других государств, ветераны военной<br>службы, ветераны труда, категории<br>граждан, подвергшихся<br>воздействию радиации вследствие<br>чернобыльской катастрофы");
        benefitBox.addItem("<html>Герои Советского Союза,<br>Герои Российской Федерации,<br>герои Социалистического Труда,<br>полные кавалеры ордена Славы,<br>полные кавалеры ордена<br>Трудовой Славы");
        benefitBox.addItem("<html>Один из родителей (усыновитель)<br>либо опекун (попечитель) в семье,<br>которая признается многодетной");
        benefitBox.setSelectedIndex(0);

        luxuryBox.addItem("Без налога на роскошь");
        luxuryBox.addItem("<html>Автомобиль стоит от 3 до 5млн. руб.,<br>возраст не более 3 лет");
        luxuryBox.addItem("<html>Автомобиль стоит от 5 до 10 млн. руб.,<br>возраст не более 5 лет");
        luxuryBox.addItem("<html>Автомобиль стоит от 10 до 15 млн. руб.,<br>возраст не более 10 лет");
        luxuryBox.addItem("<html>Автомобиль стоит от 15 млн. Руб.,<br>возраст не более 20 лет");
        benefitBox.setSelectedIndex(0);

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.insets.bottom = 5;
        mainPanel.add(titleLabel, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        mainPanel.add(surnameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        mainPanel.add(surnameField, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        mainPanel.add(nameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        mainPanel.add(nameField, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        mainPanel.add(patronymicLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        mainPanel.add(patronymicField, constraints);

        constraints.gridy = 4;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        mainPanel.add(periodLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        mainPanel.add(periodField, constraints);

        constraints.gridy = 5;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        mainPanel.add(powerLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        mainPanel.add(powerField, constraints);

        constraints.gridy = 6;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        mainPanel.add(luxuryLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        mainPanel.add(luxuryBox, constraints);

        constraints.gridy = 7;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        mainPanel.add(benefitLabel, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 2;
        mainPanel.add(benefitBox, constraints);

        constraints.gridy = 8;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        mainPanel.add(aboutUsButton, constraints);

        constraints.gridy = 9;
        mainPanel.add(calculateButton, constraints);

        constraints.gridy = 10;
        constraints.insets.bottom = 0;
        mainPanel.add(pdfButton, constraints);

        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(700, 600));
        this.setVisible(true);
    }
}
