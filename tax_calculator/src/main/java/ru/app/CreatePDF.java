package ru.app;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.stream.Stream;

public class CreatePDF {

    private BaseFont times = null;
    public static String pdfPath;
    public void Create() throws IOException {
        Document document = new Document();

        pdfPath = Order.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        pdfPath = pdfPath.substring(0, pdfPath.lastIndexOf("/")) + "/Nalog.pdf";

        System.out.println(pdfPath);
        URL imagePath = null;
        try {
            imagePath = Objects.requireNonNull(CreatePDF.class.getResource("/img/logo.png")).toURI().toURL();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }

        document.open();

        Font font = FontFactory.getFont(String.valueOf(this.getClass().getResource("/fonts/times.ttf")), BaseFont.IDENTITY_H,
                BaseFont.EMBEDDED, 0.8f, Font.NORMAL, BaseColor.BLACK);

        times = font.getBaseFont();

        Paragraph paragraph = new Paragraph();
        paragraph.add(new Paragraph("Налоговый калькулятор. Транспортный налог", new Font(times,20)));
        paragraph.add(new Paragraph("ФИО: " + MainForm.surnameField.getText() + " " + MainForm.nameField.getText() + " " + MainForm.patronymicField.getText(), new Font(times,16)));
        paragraph.add(new Paragraph("Период: " + MainForm.periodField.getText() + " мес.", new Font(times,16)));
        paragraph.add(new Paragraph("Мощность: " + MainForm.powerField.getText() + " л.с.", new Font(times,16)));
        paragraph.add(new Paragraph(MainForm.benefitBox.getSelectedItem().toString(), new Font(times,16)));
        paragraph.add(new Paragraph(MainForm.luxuryBox.getSelectedItem().toString(), new Font(times,20)));
        paragraph.add(new Paragraph("Транспортный налог - " + Order.tax + " руб.", new Font(times,20)));

        try {
            document.add(paragraph);
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }

        paragraph.clear();

        Image img = null;
        try {
            img = Image.getInstance(imagePath.toString());
        } catch (BadElementException | IOException e2) {
            e2.printStackTrace();
        }

        Objects.requireNonNull(img).setAbsolutePosition(10, 150);

        try {
            document.add(img);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        document.close();
    }

    private void addRows(PdfPTable table, String cell1, String cell2) {
        table.addCell((new Phrase(cell1, new Font(times,14))));
        table.addCell((new Phrase(cell2, new Font(times,14))));
    }

    private void addHeader(PdfPTable table) {
        Stream.of("Дополнительные услуги", "Цена").forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle, new Font(times,14)));
            table.addCell(header);
        });
    }


}